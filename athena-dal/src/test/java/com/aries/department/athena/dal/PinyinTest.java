package com.aries.department.athena.dal;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Assert;
import org.junit.Test;

import static com.aries.department.athena.core.utils.PinyinUtil.toPinyin;

public class PinyinTest {
    @Test
    public void pinyinTestWithoutFilter() throws BadHanyuPinyinOutputFormatCombination {
        String pinyin = toPinyin("哈哈1a2b", false);
        Assert.assertEquals(pinyin, "haha1a2b");
        System.out.println(pinyin);
    }

    @Test
    public void pinyinTestWithFilter() throws BadHanyuPinyinOutputFormatCombination {
        String pinyin = toPinyin("哈哈1a2b", true);
        Assert.assertEquals(pinyin, "haha");
        System.out.println(pinyin);
    }
}
