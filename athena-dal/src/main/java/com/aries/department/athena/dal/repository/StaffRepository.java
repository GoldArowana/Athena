package com.aries.department.athena.dal.repository;

import com.aries.department.athena.core.utils.PinyinUtil;
import com.aries.department.athena.dal.exception.GenIdException;
import com.aries.department.athena.dal.mapper.StaffMapper;
import com.aries.department.athena.dal.po.Staff;
import com.aries.department.athena.dal.util.SqlSessionUtil;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class StaffRepository {
    /**
     * 添加员工
     *
     * @param database 数据库名
     * @param staff    员工信息
     * @return 0失败，原因未知。1失败，生成gaeaId失败。2不成功，参数错误。3成功。4不成功,希望调用方重试。
     */
    public static int addStaff(String database, Staff staff) {
        if (staff == null) {
            return 2;
        }

        try {
            staff.setGaeaId(getNextGaeaIdByName(database, staff.getFullname()));
        } catch (GenIdException e) {
            return 1;
        }

        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);

            int effective = 0;
            try {
                effective = staffMapper.insertSelective(staff);
            } catch (PersistenceException e) {
                String template = "java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '%s' for key 'staff_gaea_id_uindex'";
                String cause = String.format(template, staff.getGaeaId());
                if (cause.equals(e.getCause().toString())) {
                    return 4;
                }
            }

            return effective > 1 ? 3 : 0;
        }
    }

    /**
     * 根据主键id查询员工信息
     *
     * @param database 数据库名
     * @param id       主键id
     * @return 员工信息
     */
    public static Staff getStaffById(String database, int id) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);

            Staff staff = staffMapper.selectByPrimaryKey(id);

            return staff;
        }
    }

    /**
     * 根据员工姓名获取员工信息
     *
     * @param database 数据库名
     * @param name     员工名
     * @return 员工信息。List。
     */
    public static List<Staff> getStaffByName(String database, String name) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);

            // 构建查询条件
            Example example = new Example(Staff.class);
            example.createCriteria().andEqualTo("fullname", name);

            // 查询
            List<Staff> staff = staffMapper.selectByExample(example);

            return staff;
        }
    }

    /**
     * <p>根据名字拼音排序，获取最后一个员工。
     * <p>例如 ["jinlong01","jinlong02","jinlong03","jinlong04"], 那么就会返回jinlong04这个员工的信息。
     *
     * @param database 数据库名
     * @param pinyin   名字拼音，例如 "jinlong"
     * @return 员工信息。
     */
    public static Staff getLastStaffBypinyin(String database, String pinyin) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);
            Example example = new Example(Staff.class);
            example.createCriteria().andLike("gaeaId", pinyin + "%");
            example.orderBy("gaeaId").desc();
            List<Staff> staffList = staffMapper.selectByExampleAndRowBounds(example, new RowBounds(0, 1));
            if (CollectionUtils.isEmpty(staffList)) {
                return null;
            }
            return staffList.get(0);
        }
    }

    /**
     * 为新入职员工新建gaeaId。例如，现已有"jinlong01","jinlong02"，那么又有叫"金龙"的员工入职时，新的gaeaId就是"jinlong03"
     *
     * @param database 数据库名
     * @param name     名字，例如"金龙"
     * @return 下一个gaeaId值
     * @throws GenIdException
     */
    public static String getNextGaeaIdByName(String database, String name) throws GenIdException {
        try {
            return getNextGaeaIdByPinyin(database, PinyinUtil.toPinyin(name, false));
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            throw new GenIdException("生成gaeaId失败", badHanyuPinyinOutputFormatCombination);
        }
    }

    /**
     * 为新入职员工新建gaeaId。例如，现已有"jinlong01","jinlong02"，那么又有叫"jinlong"的员工入职时，新的gaeaId就是"jinlong03"
     * {@code getNextGaeaIdByName()} 和{@code getNextGaeaIdByPinyin()}区别就是入参不同：一个是中文名，一个是名字的拼音。
     *
     * @param database 数据库名
     * @param pinyin   名字，例如"jinlong"
     * @return 下一个gaeaId值
     * @throws GenIdException
     */
    public static String getNextGaeaIdByPinyin(String database, String pinyin) {
        Staff lastStaffBypinyin = getLastStaffBypinyin(database, pinyin);
        if (lastStaffBypinyin == null) {
            return pinyin + "01";
        }

        String lastStaffGaeaId = lastStaffBypinyin.getGaeaId();

        // 把gaeaId的数字提取出来
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < lastStaffGaeaId.length(); i++) {
            char at = lastStaffGaeaId.charAt(i);
            if (at >= '0' && at <= '9') {
                numberBuilder.append(at);
            }
        }
        int nextId = Integer.valueOf(numberBuilder.toString()) + 1;


        if (nextId < 10) {
            return pinyin + "0" + nextId;
        }
        return pinyin + nextId;
    }
}
