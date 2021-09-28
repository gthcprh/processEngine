package com.tct.data.util;

import java.util.*;
import org.apache.commons.lang3.StringUtils;

public class StringTools extends org.apache.commons.lang3.StringUtils
{
    /** 空字符串 */
    private static final String NULLSTR = "";

    /** 下划线 */
    public static final char SEPARATOR = '_';
    public static final String SEPARATORSPACE = " ";
    public static final String SEPARATORSTR = "_";
    /** 导出数据的格式 */
    public static final String OUTTIMEFORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 获取参数不为空值
     *
     * @param value defaultValue 要判断的value
     * @return value 返回值
     */
    public static <T> T nvl(T value, T defaultValue)
    {
        return value != null ? value : defaultValue;
    }

    /**
     * * 判断一个Collection是否为空， 包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Collection<?> coll)
    {
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * * 判断一个Collection是否非空，包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Collection<?> coll)
    {
        return !isEmpty(coll);
    }

    /**
     * * 判断一个对象数组是否为空
     *
     * @param objects 要判断的对象数组
     ** @return true：为空 false：非空
     */
    public static boolean isEmpty(Object[] objects)
    {
        return isNull(objects) || (objects.length == 0);
    }

    /**
     * * 判断一个对象数组是否非空
     *
     * @param objects 要判断的对象数组
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Object[] objects)
    {
        return !isEmpty(objects);
    }

    /**
     * * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Map<?, ?> map)
    {
        return isNull(map) || map.isEmpty();
    }

    /**
     * * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Map<?, ?> map)
    {
        return !isEmpty(map);
    }

    /**
     * * 判断一个字符串是否为空串
     *
     * @param str String
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(String str)
    {
        return isNull(str) || NULLSTR.equals(str.trim());
    }

    /**
     * * 判断一个字符串是否为非空串
     *
     * @param str String
     * @return true：非空串 false：空串
     */
    public static boolean isNotEmpty(String str)
    {
        return !isEmpty(str);
    }

    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object)
    {
        return object == null;
    }

    /**
     * * 判断一个对象是否非空
     *
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object)
    {
        return !isNull(object);
    }

    /**
     * * 判断一个对象是否是数组类型（Java基本型别的数组）
     *
     * @param object 对象
     * @return true：是数组 false：不是数组
     */
    public static boolean isArray(Object object)
    {
        return isNotNull(object) && object.getClass().isArray();
    }

    /**
     * 去空格
     */
    public static String trim(String str)
    {
        return (str == null ? "" : str.trim());
    }
    /**
     * 分割字符串
     */
    public static List<String> split(List<String> strs, List<String> regexs)
    {
        List<String> rlts=new ArrayList<>();
        if (strs.size()==1){
            String str=strs.get(0);
            if (regexs.size()==1){
                String[] tmpArr=str.split(regexs.get(0));
                return removeNullStringArray(tmpArr);
            }else{
                String regex=regexs.get(0);
                List<String> newRegexs =  regexs.subList(1, regexs.size() );
                List<String> rlttmp=split( Arrays.asList(str.split(regex)),newRegexs );
                return rlttmp;
            }
        }else {
            for (String str:strs){
                List<String> tmp=new ArrayList<>();
                tmp.add(str);
                List<String> rlt=split(tmp,regexs);
                rlts.addAll(rlt);
            }
        }
        return rlts;
    }
    /**
     * 除去字符串数组中的空字符串
     */
    public static List removeNullStringArray(String[] arrayString) {
        List<String> list1 = new ArrayList<String>();
        for (int i=0 ;i<arrayString.length; i++) {
            if(arrayString[i]!=null && arrayString[i].length()!=0){ //过滤掉数组arrayString里面的空字符串
                list1.add(arrayString[i]);
            }
        }
        return list1;
    }
    /**
     * 截取字符串
     *
     * @param str 字符串
     * @param start 开始
     * @return 结果
     */
    public static String substring(final String str, int start)
    {
        if (str == null)
        {
            return NULLSTR;
        }

        if (start < 0)
        {
            start = str.length() + start;
        }

        if (start < 0)
        {
            start = 0;
        }
        if (start > str.length())
        {
            return NULLSTR;
        }

        return str.substring(start);
    }

    /**
     * 截取字符串
     *
     * @param str 字符串
     * @param start 开始
     * @param end 结束
     * @return 结果
     */
    public static String substring(final String str, int start, int end)
    {
        if (str == null)
        {
            return NULLSTR;
        }

        if (end < 0)
        {
            end = str.length() + end;
        }
        if (start < 0)
        {
            start = str.length() + start;
        }

        if (end > str.length())
        {
            end = str.length();
        }

        if (start > end)
        {
            return NULLSTR;
        }

        if (start < 0)
        {
            start = 0;
        }
        if (end < 0)
        {
            end = 0;
        }

        return str.substring(start, end);
    }

    /**
     * 格式化文本, {} 表示占位符<br>
     * 此方法只是简单将占位符 {} 按照顺序替换为参数<br>
     * 如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可<br>
     * 例：<br>
     * 通常使用：format("this is {} for {}", "a", "b") -> this is a for b<br>
     * 转义{}： format("this is \\{} for {}", "a", "b") -> this is \{} for a<br>
     * 转义\： format("this is \\\\{} for {}", "a", "b") -> this is \a for b<br>
     *
     * @param template 文本模板，被替换的部分用 {} 表示
     * @param params 参数值
     * @return 格式化后的文本
     */
    public static String format(String template, Object... params)
    {
        if (isEmpty(params) || isEmpty(template))
        {
            return template;
        }
        return StrFormatter.format(template, params);
    }

    /**
     * 下划线转驼峰命名
     */
    public static String toUnderScoreCase(String str)
    {
        if (str == null)
        {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        // 前置字符是否大写
        boolean preCharIsUpperCase = true;
        // 当前字符是否大写
        boolean curreCharIsUpperCase = true;
        // 下一字符是否大写
        boolean nexteCharIsUpperCase = true;
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (i > 0)
            {
                preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
            }
            else
            {
                preCharIsUpperCase = false;
            }

            curreCharIsUpperCase = Character.isUpperCase(c);

            if (i < (str.length() - 1))
            {
                nexteCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
            }

            if (preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase)
            {
                sb.append(SEPARATOR);
            }
            else if ((i != 0 && !preCharIsUpperCase) && curreCharIsUpperCase)
            {
                sb.append(SEPARATOR);
            }
            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 是否包含字符串
     *
     * @param str 验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs)
    {
        if (str != null && strs != null)
        {
            for (String s : strs)
            {
                if (str.equalsIgnoreCase(trim(s)))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。 例如：HELLO_WORLD->HelloWorld
     *
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String convertToCamelCase(String name)
    {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty())
        {
            // 没必要转换
            return "";
        }
        else if (!name.contains("_"))
        {
            // 不含下划线，仅将首字母大写
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String[] camels = name.split("_");
        for (String camel : camels)
        {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty())
            {
                continue;
            }
            // 首字母大写
            result.append(camel.substring(0, 1).toUpperCase());
            result.append(camel.substring(1).toLowerCase());
        }
        return result.toString();
    }

    /**
     * 驼峰式命名法 例如：user_name->userName
     */
    public static String toCamelCase(String s)
    {
        if (s == null)
        {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if (c == SEPARATOR)
            {
                upperCase = true;
            }
            else if (upperCase)
            {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj)
    {
        return (T) obj;
    }


    /**
     * 把字符串数字类型的数字取出来（只取遇到非数字字符前，包括空格）
     * @param str
     * <li>"1-0我5013我24a5c6"    》 1</li>
     * <li>"10  5 013我24a 5c6"  》 10</li>
     * <li>"105013我24a5c6"      》 105013</li>
     * <li>"000"                 》 000</li>
     * <li>"00010123600"         》 00010123600</li>
     * <li>"好20我1a2b"           》  空字符串</li>
     * @return
     */
    public static String getPrefixNumberText(String str){
        if(StringUtils.isBlank(str)){
            throw new RuntimeException("参数str不能为空");
        }
        StringBuffer number = new StringBuffer("");

        String[] strArray = str.split("");
        for (int i=1; i<strArray.length; i++) {
            if(RegUtils.isNumberText(strArray[i])){
                number.append(strArray[i]);
            }else{
                break;
            }
        }
        return number.toString();
    }


    /**
     * 把字符串数字类型的数字取出来（只取遇到非数字字符前，但不包括空格）
     * @param str
     * <li>"1-0我5013我24a5c6"    》 1</li>
     * <li>"10  5 013我24a 5c6"  》 105013</li>
     * <li>"105013我24a5c6"      》 105013</li>
     * <li>"000"                 》 000</li>
     * <li>"00010123600"         》 00010123600</li>
     * <li>"00010123我600"        》 00010123</li>
     * @return
     */
    public static String getPrefixNumberTextIgnoreSpace(String str){
        if(StringUtils.isBlank(str)){
            throw new RuntimeException("参数str不能为空");
        }
        StringBuffer number = new StringBuffer("");

        String[] strArray = str.split("");
        for (String string : strArray) {
            if(!StringUtils.isBlank(string)){
                if(RegUtils.isNumberText(string)){
                    number.append(string);
                }else{
                    break;
                }
            }
        }
        return number.toString();
    }


    /**
     * 把字符串数字类型的所有数字取出来
     * @param str
     * <li>"1-000我10123我60#0"       》 100010123600</li>
     * <li>"00010-+123我600"         》 00010123600</li>
     * <li>"我是2019我600"            》 2019600</li>
     * <li>"我是20 -19我    600"         》 2019600</li>
     * @return
     */
    public static String getNumberText(String str){
        if(StringUtils.isBlank(str)){
            throw new RuntimeException("参数str不能为空");
        }
        StringBuffer number = new StringBuffer("");

        String[] strArray = str.split("");
        for (String string : strArray) {
            if(!StringUtils.isBlank(string) && RegUtils.isNumberText(string)){
                number.append(string);
            }
        }
        return number.toString();
    }


    /**
     * 把字符串数字类型的数字取出来（只取遇到非数字字符前，不包括空格）转换成数字
     * @param str
     * <li>"1-0我5013我24a5c6"    》 1</li>
     * <li>"10  5 013我24a 5c6"  》 105013</li>
     * <li>"105013我24a5c6"      》 105013</li>
     * <li>"000"                 》 0</li>
     * <li>"00010123600"         》 10123600</li>
     * @return
     */
    public static long getPrefixNumber(String str){
        String number = getPrefixNumberTextIgnoreSpace(str);
        if(StringUtils.isBlank(number)){
            return 0;
        }

        //去掉前面为0的，如0099变成99
        String[] texts = number.split("");
        StringBuffer numbers = new StringBuffer("");
        for (String text : texts) {
            if(numbers.length() < 1){
                if(text == "0"){
                    continue;
                }
            }
            numbers.append(text);
        }

        if(numbers.length() < 1){
            return 0;
        }
        return Long.parseLong(numbers.toString());
    }


    /**
     * 把字符串数字类型的数字取出来转换成数字
     * @param str
     * <li>"1-000我10123我60#0"   》 100010123600</li>
     * <li>"00010-+123我600"      》 10123600</li>
     * <li>"我是2019我600"         》 2019600</li>
     * <li>"我是20 -19我    600"     》 2019600</li>
     * @return
     */
    public static long getNumber(String str){
        String number = getNumberText(str);
        if(StringUtils.isBlank(number)){
            return 0;
        }

        //去掉前面为0的，如0099变成99
        String[] texts = number.split("");
        StringBuffer numbers = new StringBuffer("");
        for (String text : texts) {
            if(numbers.length() < 1){
                if(text == "0"){
                    continue;
                }
            }
            numbers.append(text);
        }

        if(numbers.length() < 1){
            return 0;
        }
        return Long.parseLong(numbers.toString());
    }
}
