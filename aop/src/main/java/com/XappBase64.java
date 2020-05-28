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
public class XappBase64 {
    public static void main(String[] args) throws Exception {
        //payout
        Map<String, String> params =new HashMap<>();
        params.put("event","TRANSFER_SUCCESS");
        params.put("transferId","119048c603611001");
        params.put("referenceId","12345");
        params.put("eventTime","2020-05-18 15:47:55");
        //params.put("acknowledged","1");
        String secret ="59e279e677e3d977bbf24bcbb34c01a55f5eeb88";
        String sign = params.get("signature");
        params.remove("signature");
        SortedSet<String> keys = new TreeSet<>(params.keySet());
        StringBuilder data = new StringBuilder();
        for (String key : keys) {
            data.append(params.get(key));
        }
        Mac sha256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        sha256.init(secretKey);
        String computedSignature = Base64.getEncoder().encodeToString(sha256.doFinal(data.toString().getBytes()));
        System.out.println(computedSignature);
    }
}
