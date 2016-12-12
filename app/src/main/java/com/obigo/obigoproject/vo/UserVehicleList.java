package com.obigo.obigoproject.vo;

import java.util.List;

/**
 * Created by O BI HE ROCK on 2016-12-12.
 */

public class UserVehicleList {
    List<UserVehicleListVO> userVehicleVO;

    public List<UserVehicleListVO> getUserVehicleVO() {
        return userVehicleVO;
    }

    public void setUserVehicleVO(List<UserVehicleListVO> userVehicleVO) {
        this.userVehicleVO = userVehicleVO;
    }

    @Override
    public String toString() {
        return "UserVehicleList{" +
                "userVehicleVO=" + userVehicleVO +
                '}';
    }
}
