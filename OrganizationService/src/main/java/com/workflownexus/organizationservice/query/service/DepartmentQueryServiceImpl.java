package com.workflownexus.organizationservice.query.service;

import com.workflownexus.organizationservice.common.mappers.DepartmentMapper;
import com.workflownexus.organizationservice.data.entity.Departments;
import com.workflownexus.organizationservice.data.repository.DepartmentRepo;
import com.workflownexus.organizationservice.query.model.response.DepartmentResponse;
import com.workflownexus.organizationservice.query.query.departmentQuery.GetDepartment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentQueryServiceImpl implements IDepartmentQueryService{

    private final DepartmentRepo departmentRepo;

    @Override
    public List<DepartmentResponse> getAllDepartment() {
        List<Departments> departmentsList = departmentRepo.findAll();

        if(departmentsList != null){
            List<DepartmentResponse> responseList = mapDepartmentEntityToDepartmentResList(departmentsList);
            return responseList;
        }

        return null;
    }

    @Override
    public DepartmentResponse getDepartment(GetDepartment getDepartment) {
        Departments department = departmentRepo.findById(getDepartment.getDepartmentId()).orElse(null);

        if(department != null){
            DepartmentResponse response = mapDepartmentEntityToDepartmentRes(department);
            return response;
        }

        return null;
    }

    private List<DepartmentResponse> mapDepartmentEntityToDepartmentResList(List<Departments> departments){

        List<DepartmentResponse> responseList = new ArrayList<>();
        for (Departments department: departments) {
            DepartmentResponse response = mapDepartmentEntityToDepartmentRes(department);
           responseList.add(response);
        }
        return responseList;
    }

    private DepartmentResponse mapDepartmentEntityToDepartmentRes(Departments department){

        DepartmentResponse response = (DepartmentResponse) DepartmentMapper.INSTANCE.mapToDepartmentEntity(department);
        return response;
    }
}
