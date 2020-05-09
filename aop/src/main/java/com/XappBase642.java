package com;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2020/1/16 10:05
 */
public class XappBase642 {
    public static void main(String[] args) throws Exception {
        //payout
        boolean result = false;
        try {
            String secretKey = "b691d50eb042b1998ed68aadd355a0620089b726";
            String sign = "";
            Map<String, String> params = new HashMap<>();
            params.put("orderId", "10e5e416eff98001");
            params.put("txStatus", "SUCCESS");
            params.put("txTime", "2020-02-16 10:10:05");
            String data = params.get("orderId") + params.get("orderAmount") + params.get("referenceId") + params.get("txStatus") + params.get("paymentMode") +
                    params.get("txMsg") + params.get("txTime");
            System.out.println(data);
            Mac sha256 = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
            sha256.init(secretKeySpec);
            String computedSignature = Base64.getEncoder().encodeToString(sha256.doFinal(data.getBytes()));
            System.out.println(computedSignature);
        } catch (Exception ex) {
        }
    }
}
