package com.aries.department.athena.core.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinUtil {
    /**
     * @param str    将str变为拼音
     * @param filter 是否过滤汉字以外的字符。当str="哈哈abc"时，如果filter=true,那么输出"haha"; 如果filter=false, 那么输出"hahaabc"
     * @return 返回拼音
     * @throws BadHanyuPinyinOutputFormatCombination
     */
    public static String toPinyin(String str, boolean filter) throws BadHanyuPinyinOutputFormatCombination {
        StringBuilder result = new StringBuilder();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        for (int i = 0; i < str.length(); i++) {
            String[] pinyinStringArray = PinyinHelper.toHanyuPinyinStringArray(str.charAt(i), format);
            if (pinyinStringArray != null && pinyinStringArray.length > 0) {
                result.append(pinyinStringArray[0]);
            } else if (!filter) {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
