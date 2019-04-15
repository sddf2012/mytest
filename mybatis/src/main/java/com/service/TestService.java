package com.service;

import com.entity.Test;

/**
 * @author liu peng bo
 * @date 2019/4/11
 */
public interface TestService {
    int updateAIncr(int id);

    int updateA(int id);

    int updateAVersion(int id);

    int selectAForUpdate(int id);

    Test selectById(int id);

    void update(int id);
}
