package com.kaka.LC.LC1_100.LC91_100.topic94;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.regex.Pattern;

/**
 * @Author : kaka
 * @Date: 2022-03-10 09:45
 *
 * @Description: 468. 验证IP地址
 *
 * 给定一个字符串 queryIP。
 * 如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
 *
 * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。
 * 例如: “192.168.1.1” 、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址;
 * “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
 *
 * 一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
 * 1 <= xi.length <= 4
 * xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
 * 在 xi 中允许前导零。
 * 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，
 * 而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
 *
 * 链接：https://leetcode-cn.com/problems/validate-ip-address
 */
public class ValidIPAddress {
    /**
     * 自带API
     */
    public String vaildIPaddress(String IP) {
        try {
            return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6" : "IPv4";
        } catch (Exception e) {}

        return "Neither";
    }

    /**
     * 正则表达式
     */
    String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern patternIPv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");
    String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    Pattern patternIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

    public String vaildIPAddress2(String IP) {
        if (IP.contains(".")) {
            return (patternIPv4.matcher(IP).matches()) ? "IPv4" : "Neither";
        } else if (IP.contains(":")) {
            return (patternIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    /**
     * 分治
     */
    public String validIPAddress3(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return vaildIPv4(IP);
        } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validIPv6(IP);
        } else {
            return "Neither";
        }
    }

    private String validIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
            // Validate hexadecimal in range (0, 2**16):
            // 1. at least one and not more than 4 hexdigits in one chunk
            if (x.length() == 0 || x.length() > 4) {
                return "Neither";
            }
            // 2. only hexdigits are allowed: 0-9, a-f, A-F
            for (Character ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1){
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

    private String vaildIPv4(String IP) {
        String[] nums = IP.split("\\.", -1);
        for (String num : nums) {
            if (num.length() == 0 || num.length() > 3) {
                return "Neither";
            }
            if (num.charAt(0) == '0' && num.length() != 1) {
                return "Neither";
            }
            for (char ch : num.toCharArray()) {
                if (! Character.isDigit(ch)){
                    return "Neither";
                }
            }
            if (Integer.parseInt(num) > 255){
                return "Neither";
            }
        }
        return "IPv4";
    }
}
