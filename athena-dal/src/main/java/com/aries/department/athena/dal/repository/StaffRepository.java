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

import java.util.Collections;
import java.util.List;

import static com.aries.department.athena.dal.repository.StaffRepository.State.*;

public class StaffRepository {
    public enum State {
        error(0),
        FAIL(1),
        PARAM_ERROR(2),
        SUCCESS(3),
        NEED_RECALL(4);

        private int code;

        State(int code) {
            this.code = code;
        }

        public int code() {
            return this.code;
        }
    }

    /**
     * 添加员工
     *
     * @param database 数据库名
     * @param staff    员工信息
     * @return 0失败，原因未知。1失败，生成gaeaAccount失败。2不成功，参数错误。3成功。4不成功,希望调用方重试。
     */
    public static int addStaff(String database, Staff staff) {
        if (staff == null) {
            return PARAM_ERROR.code();
        }

        try {
            staff.setGaeaAccount(getNextGaeaAccountByName(database, staff.getFullname()));
        } catch (GenIdException e) {
            return FAIL.code();
        }

        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);

            int effective = 0;
            try {
                effective = staffMapper.insertSelective(staff);
            } catch (PersistenceException e) {
                String template = "java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '%s' for key 'staff_gaea_id_uindex'";
                String cause = String.format(template, staff.getGaeaAccount());
                if (cause.equals(e.getCause().toString())) {
                    return NEED_RECALL.code();
                }
            }

            return effective >= 1 ? SUCCESS.code() : error.code();
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
     * 根据员工姓名获取员工信息
     *
     * @param database 数据库名
     * @param pinyin   员工名拼音
     * @return 员工信息。List。
     */
    public static List<Staff> getStaffByPinyin(String database, String pinyin) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);
            Example example = new Example(Staff.class);
            example.createCriteria().andLike("gaeaAccount", pinyin + "%");
            List<Staff> staffList = staffMapper.selectByExample(example);

            // 防止返回null
            if (CollectionUtils.isEmpty(staffList)) {
                return Collections.emptyList();
            }

            return staffList;
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
            example.createCriteria().andLike("gaeaAccount", pinyin + "%");
            example.orderBy("gaeaAccount").desc();
            List<Staff> staffList = staffMapper.selectByExampleAndRowBounds(example, new RowBounds(0, 1));
            if (CollectionUtils.isEmpty(staffList)) {
                return null;
            }
            return staffList.get(0);
        }
    }

    /**
     * 为新入职员工新建gaeaAccount。例如，现已有"jinlong01","jinlong02"，那么又有叫"金龙"的员工入职时，新的gaeaAccount就是"jinlong03"
     *
     * @param database 数据库名
     * @param name     名字，例如"金龙"
     * @return 下一个gaeaAccount值
     * @throws GenIdException
     */
    public static String getNextGaeaAccountByName(String database, String name) throws GenIdException {
        try {
            return getNextGaeaAccountByPinyin(database, PinyinUtil.toPinyin(name, false));
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            throw new GenIdException("生成gaeaAccount失败", badHanyuPinyinOutputFormatCombination);
        }
    }

    /**
     * 为新入职员工新建gaeaAccount。例如，现已有"jinlong01","jinlong02"，那么又有叫"jinlong"的员工入职时，新的gaeaAccount就是"jinlong03"
     * {@code getNextGaeaAccountByName()} 和{@code getNextGaeaAccountByPinyin()}区别就是入参不同：一个是中文名，一个是名字的拼音。
     *
     * @param database 数据库名
     * @param pinyin   名字，例如"jinlong"
     * @return 下一个gaeaAccount值
     * @throws GenIdException
     */
    public static String getNextGaeaAccountByPinyin(String database, String pinyin) {
        Staff lastStaffBypinyin = getLastStaffBypinyin(database, pinyin);
        if (lastStaffBypinyin == null) {
            return pinyin + "01";
        }

        String lastStaffGaeaAccount = lastStaffBypinyin.getGaeaAccount();

        // 把gaeaAccount的数字提取出来
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < lastStaffGaeaAccount.length(); i++) {
            char at = lastStaffGaeaAccount.charAt(i);
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

    public static boolean updateStaffById(String database, long id, Staff staff) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);
            staff.setId(id);
            int effect = staffMapper.updateByPrimaryKeySelective(staff);

            return effect > 0;
        }
    }

    public static List<Staff> batchGetStaffByDepartmentId(String database, long departmentId, int pageNum, int pageSize) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);

            Example example = new Example(Staff.class);
            if (departmentId > 0) {
                example.createCriteria().andEqualTo("departmentId", departmentId);
            }
            example.orderBy("id").asc();
            int offset = (pageNum - 1) * pageSize;
            int limit = pageSize;
            List<Staff> staffList = staffMapper.selectByExampleAndRowBounds(example, new RowBounds(offset, limit));

            // 防止返回null
            return CollectionUtils.isEmpty(staffList) ? Collections.emptyList() : staffList;
        }
    }

    public static long getStaffCountByDepartmentId(String database, long departmentId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);

            Example example = new Example(Staff.class);
            example.createCriteria().andEqualTo("departmentId", departmentId);

            return staffMapper.selectCountByExample(example);
        }
    }
}
