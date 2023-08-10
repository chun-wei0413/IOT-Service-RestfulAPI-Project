package com.example.Fproject.handler;

import com.example.Fproject.apibody.ManagerBean;
import com.example.Fproject.database.entity.Manager;

import java.util.List;

public interface ManagerHandler {
    String addManager(ManagerBean.AddManagerBean addManagerBean);
    String deleteManager(ManagerBean.DeleteManagerBean deleteManagerBean);

    List<Manager.member> listManager(ManagerBean.ManagerListBean managerListBean);
}
