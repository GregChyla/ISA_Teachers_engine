package com.isa.teachers.service;

import com.isa.teachers.dao.TeacherDao;
import com.isa.teachers.dto.TeacherNameDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class TeacherService {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    TeacherDao teacherDao;

    public List<TeacherNameDTO> findAllTeachers() {
        List<TeacherNameDTO> teacherNameDTOList = new ArrayList<>();

        teacherDao.findAll().forEach(teacher -> {
            TeacherNameDTO teacherNameDTO = new TeacherNameDTO();
            teacherNameDTO.setFirstName(teacher.getFirstName());
            teacherNameDTO.setLastName(teacher.getLastName());

            logger.info("Adding teacher to dto list: {}", teacherNameDTO.getFirstName() + " " + teacherNameDTO.getLastName());

            teacherNameDTOList.add(teacherNameDTO);
        });

        return teacherNameDTOList;
    }
}
