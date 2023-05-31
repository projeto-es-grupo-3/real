package com.example.classroom.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import com.example.classroom.breadcrumb.BreadcrumbService;
import com.example.classroom.dto.FieldOfStudyDto;
import com.example.classroom.enums.AcademicTitle;
import com.example.classroom.enums.LevelOfEducation;
import com.example.classroom.enums.ModeOfStudy;
import com.example.classroom.enums.Semester;
import com.example.classroom.model.Department;
import com.example.classroom.model.FieldOfStudy;
import com.example.classroom.model.Subject;
import com.example.classroom.repository.DepartmentRepository;
import com.example.classroom.repository.FieldOfStudyRepository;
import com.example.classroom.repository.SubjectRepository;
import com.example.classroom.service.DepartmentService;
import com.example.classroom.service.FieldOfStudyService;
import com.example.classroom.service.SubjectService;
import jakarta.servlet.http.HttpServletRequest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

class FieldOfStudyControllerTest {

    /**
     * Method under test: {@link FieldOfStudyController#getAllFieldsOfStudy(Model, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllFieldsOfStudy2() {
        ArrayList<FieldOfStudy> fieldOfStudyList = new ArrayList<>();
        fieldOfStudyList.add(null);
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllByNameContainingIgnoreCase(Mockito.<String>any())).thenReturn(new ArrayList<>());
        when(repository.findAll(Mockito.<Sort>any())).thenReturn(fieldOfStudyList);
        when(repository.findAllByLevelOfEducation(Mockito.<LevelOfEducation>any(), Mockito.<Sort>any()))
                .thenReturn(new ArrayList<>());
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        ConcurrentModel model = new ConcurrentModel();
        fieldOfStudyController.getAllFieldsOfStudy(model, new MockHttpServletRequest());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getAllFieldsOfStudy(Model, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllFieldsOfStudy4() {
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchAllByLevelOfEducationSortedByName(Mockito.<LevelOfEducation>any()))
                .thenReturn(new ArrayList<>());
        when(service.fetchAllGroupedByNameAndSortedByName()).thenReturn(new HashMap<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository2, new ModelMapper()), null);
        ConcurrentModel model = new ConcurrentModel();
        fieldOfStudyController.getAllFieldsOfStudy(model, new MockHttpServletRequest());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getAllFieldsOfStudy(Model, HttpServletRequest)}
     */
    @Test
    void testGetAllFieldsOfStudy5() {

        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchAllByLevelOfEducationSortedByName(Mockito.<LevelOfEducation>any()))
                .thenReturn(new ArrayList<>());
        when(service.fetchAllGroupedByNameAndSortedByName()).thenReturn(new HashMap<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository2, new ModelMapper()), crumb);
        ConcurrentModel model = new ConcurrentModel();
        assertEquals("field-of-study/all-fieldsOfStudy",
                fieldOfStudyController.getAllFieldsOfStudy(model, new MockHttpServletRequest()));
        verify(service, atLeast(1)).fetchAllByLevelOfEducationSortedByName(Mockito.<LevelOfEducation>any());
        verify(service).fetchAllGroupedByNameAndSortedByName();
        verify(crumb).getBreadcrumbs(Mockito.<String>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getAllFieldsOfStudy(Model, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllFieldsOfStudy6() {


        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchAllByLevelOfEducationSortedByName(Mockito.<LevelOfEducation>any()))
                .thenReturn(new ArrayList<>());
        when(service.fetchAllGroupedByNameAndSortedByName()).thenReturn(new HashMap<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository2, new ModelMapper()), crumb);
        fieldOfStudyController.getAllFieldsOfStudy(new ConcurrentModel(), null);
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudy(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetFieldOfStudy() {

        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getFieldOfStudy(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudy(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetFieldOfStudy2() {
        ArrayList<Subject> subjectList = new ArrayList<>();
        subjectList.add(new Subject());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(subjectList);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getFieldOfStudy(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudy(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetFieldOfStudy3() {
        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.BACH);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        Optional<FieldOfStudy> ofResult = Optional.of(fieldOfStudy);
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(repository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-view",
                fieldOfStudyController.getFieldOfStudy(1L, request, new ConcurrentModel()));
        verify(repository).findAllSubjectsFromFieldOfStudy(Mockito.<Long>any());
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(fieldOfStudy, atLeast(1)).getTitle();
        verify(fieldOfStudy, atLeast(1)).getLevelOfEducation();
        verify(fieldOfStudy, atLeast(1)).getMode();
        verify(fieldOfStudy, atLeast(1)).getDepartment();
        verify(fieldOfStudy, atLeast(1)).getId();
        verify(fieldOfStudy, atLeast(1)).getDescription();
        verify(fieldOfStudy, atLeast(1)).getImage();
        verify(fieldOfStudy, atLeast(1)).getName();
        verify(fieldOfStudy, atLeast(1)).getStudents();
        verify(fieldOfStudy, atLeast(1)).getSubjects();
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudy(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetFieldOfStudy4() {
        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.ENG);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        Optional<FieldOfStudy> ofResult = Optional.of(fieldOfStudy);
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(repository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-view",
                fieldOfStudyController.getFieldOfStudy(1L, request, new ConcurrentModel()));
        verify(repository).findAllSubjectsFromFieldOfStudy(Mockito.<Long>any());
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(fieldOfStudy, atLeast(1)).getTitle();
        verify(fieldOfStudy, atLeast(1)).getLevelOfEducation();
        verify(fieldOfStudy, atLeast(1)).getMode();
        verify(fieldOfStudy, atLeast(1)).getDepartment();
        verify(fieldOfStudy, atLeast(1)).getId();
        verify(fieldOfStudy, atLeast(1)).getDescription();
        verify(fieldOfStudy, atLeast(1)).getImage();
        verify(fieldOfStudy, atLeast(1)).getName();
        verify(fieldOfStudy, atLeast(1)).getStudents();
        verify(fieldOfStudy, atLeast(1)).getSubjects();
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudy(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetFieldOfStudy5() {
        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.MGR);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        Optional<FieldOfStudy> ofResult = Optional.of(fieldOfStudy);
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(repository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-view",
                fieldOfStudyController.getFieldOfStudy(1L, request, new ConcurrentModel()));
        verify(repository).findAllSubjectsFromFieldOfStudy(Mockito.<Long>any());
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(fieldOfStudy, atLeast(1)).getTitle();
        verify(fieldOfStudy, atLeast(1)).getLevelOfEducation();
        verify(fieldOfStudy, atLeast(1)).getMode();
        verify(fieldOfStudy, atLeast(1)).getDepartment();
        verify(fieldOfStudy, atLeast(1)).getId();
        verify(fieldOfStudy, atLeast(1)).getDescription();
        verify(fieldOfStudy, atLeast(1)).getImage();
        verify(fieldOfStudy, atLeast(1)).getName();
        verify(fieldOfStudy, atLeast(1)).getStudents();
        verify(fieldOfStudy, atLeast(1)).getSubjects();
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudy(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetFieldOfStudy6() {

        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getFieldOfStudy(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudy(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetFieldOfStudy7() {
        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.BACH);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        Optional<FieldOfStudy> ofResult = Optional.of(fieldOfStudy);
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(repository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        FieldOfStudyService service = new FieldOfStudyService(repository, null);

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getFieldOfStudy(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudy(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetFieldOfStudy8() {

        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.BACH);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        Optional<FieldOfStudy> ofResult = Optional.of(fieldOfStudy);
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(repository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("crumbs");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("crumbs");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        ModelMapper mapper = mock(ModelMapper.class);
        when(mapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(fieldOfStudyDto);
        FieldOfStudyService service = new FieldOfStudyService(repository, mapper);

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-view",
                fieldOfStudyController.getFieldOfStudy(1L, request, new ConcurrentModel()));
        verify(repository).findAllSubjectsFromFieldOfStudy(Mockito.<Long>any());
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(mapper, atLeast(1)).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudy(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetFieldOfStudy9() {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        when(service.getNumberOfSemesters(Mockito.<Long>any())).thenReturn(10);
        when(service.getSumOfEctsPointsFromAllSemesters(Mockito.<Long>any())).thenReturn(1);
        when(service.getImagePath(Mockito.<Long>any())).thenReturn("Image Path");
        when(service.splitDescription(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-view",
                fieldOfStudyController.getFieldOfStudy(1L, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(service).getNumberOfSemesters(Mockito.<Long>any());
        verify(service).getSumOfEctsPointsFromAllSemesters(Mockito.<Long>any());
        verify(service).getImagePath(Mockito.<Long>any());
        verify(service).splitDescription(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudy(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetFieldOfStudy10() {

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        when(service.getNumberOfSemesters(Mockito.<Long>any())).thenReturn(10);
        when(service.getSumOfEctsPointsFromAllSemesters(Mockito.<Long>any())).thenReturn(1);
        when(service.getImagePath(Mockito.<Long>any())).thenReturn("Image Path");
        when(service.splitDescription(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository2, new ModelMapper()), null);
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getFieldOfStudy(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudy(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetFieldOfStudy11() {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        when(service.getNumberOfSemesters(Mockito.<Long>any())).thenReturn(10);
        when(service.getSumOfEctsPointsFromAllSemesters(Mockito.<Long>any())).thenReturn(1);
        when(service.getImagePath(Mockito.<Long>any())).thenReturn("Image Path");
        when(service.splitDescription(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository2, new ModelMapper()), crumb);
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-view",
                fieldOfStudyController.getFieldOfStudy(1L, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(service).getNumberOfSemesters(Mockito.<Long>any());
        verify(service).getSumOfEctsPointsFromAllSemesters(Mockito.<Long>any());
        verify(service).getImagePath(Mockito.<Long>any());
        verify(service).splitDescription(Mockito.<Long>any());
        verify(crumb).getBreadcrumbs(Mockito.<String>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudySubjects(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetFieldOfStudySubjects() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getFieldOfStudySubjects(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudySubjects(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetFieldOfStudySubjects2() {

        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.BACH);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        Optional<FieldOfStudy> ofResult = Optional.of(fieldOfStudy);
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(repository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-subjects",
                fieldOfStudyController.getFieldOfStudySubjects(1L, request, new ConcurrentModel()));
        verify(repository, atLeast(1)).findAllSubjectsFromFieldOfStudy(Mockito.<Long>any());
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(fieldOfStudy, atLeast(1)).getTitle();
        verify(fieldOfStudy, atLeast(1)).getLevelOfEducation();
        verify(fieldOfStudy, atLeast(1)).getMode();
        verify(fieldOfStudy, atLeast(1)).getDepartment();
        verify(fieldOfStudy, atLeast(1)).getId();
        verify(fieldOfStudy, atLeast(1)).getDescription();
        verify(fieldOfStudy, atLeast(1)).getImage();
        verify(fieldOfStudy, atLeast(1)).getName();
        verify(fieldOfStudy, atLeast(1)).getStudents();
        verify(fieldOfStudy, atLeast(1)).getSubjects();
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudySubjects(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetFieldOfStudySubjects3() {
        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.BACH);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        Optional<FieldOfStudy> ofResult = Optional.of(fieldOfStudy);

        ArrayList<Subject> subjectList = new ArrayList<>();
        subjectList.add(new Subject());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(subjectList);
        when(repository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getFieldOfStudySubjects(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudySubjects(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetFieldOfStudySubjects4() {
        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.ENG);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        Optional<FieldOfStudy> ofResult = Optional.of(fieldOfStudy);
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(repository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-subjects",
                fieldOfStudyController.getFieldOfStudySubjects(1L, request, new ConcurrentModel()));
        verify(repository, atLeast(1)).findAllSubjectsFromFieldOfStudy(Mockito.<Long>any());
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(fieldOfStudy, atLeast(1)).getTitle();
        verify(fieldOfStudy, atLeast(1)).getLevelOfEducation();
        verify(fieldOfStudy, atLeast(1)).getMode();
        verify(fieldOfStudy, atLeast(1)).getDepartment();
        verify(fieldOfStudy, atLeast(1)).getId();
        verify(fieldOfStudy, atLeast(1)).getDescription();
        verify(fieldOfStudy, atLeast(1)).getImage();
        verify(fieldOfStudy, atLeast(1)).getName();
        verify(fieldOfStudy, atLeast(1)).getStudents();
        verify(fieldOfStudy, atLeast(1)).getSubjects();
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudySubjects(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetFieldOfStudySubjects5() {
        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.MGR);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        Optional<FieldOfStudy> ofResult = Optional.of(fieldOfStudy);
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(repository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-subjects",
                fieldOfStudyController.getFieldOfStudySubjects(1L, request, new ConcurrentModel()));
        verify(repository, atLeast(1)).findAllSubjectsFromFieldOfStudy(Mockito.<Long>any());
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(fieldOfStudy, atLeast(1)).getTitle();
        verify(fieldOfStudy, atLeast(1)).getLevelOfEducation();
        verify(fieldOfStudy, atLeast(1)).getMode();
        verify(fieldOfStudy, atLeast(1)).getDepartment();
        verify(fieldOfStudy, atLeast(1)).getId();
        verify(fieldOfStudy, atLeast(1)).getDescription();
        verify(fieldOfStudy, atLeast(1)).getImage();
        verify(fieldOfStudy, atLeast(1)).getName();
        verify(fieldOfStudy, atLeast(1)).getStudents();
        verify(fieldOfStudy, atLeast(1)).getSubjects();
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudySubjects(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetFieldOfStudySubjects6() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getFieldOfStudySubjects(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudySubjects(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetFieldOfStudySubjects7() {
        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.BACH);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        Optional<FieldOfStudy> ofResult = Optional.of(fieldOfStudy);
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(repository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        FieldOfStudyService service = new FieldOfStudyService(repository, null);

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getFieldOfStudySubjects(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudySubjects(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetFieldOfStudySubjects8() {
        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.BACH);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        Optional<FieldOfStudy> ofResult = Optional.of(fieldOfStudy);
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAllSubjectsFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new ArrayList<>());
        when(repository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("crumbs");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("crumbs");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        ModelMapper mapper = mock(ModelMapper.class);
        when(mapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(fieldOfStudyDto);
        FieldOfStudyService service = new FieldOfStudyService(repository, mapper);

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-subjects",
                fieldOfStudyController.getFieldOfStudySubjects(1L, request, new ConcurrentModel()));
        verify(repository, atLeast(1)).findAllSubjectsFromFieldOfStudy(Mockito.<Long>any());
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(mapper, atLeast(1)).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudySubjects(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetFieldOfStudySubjects9() {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        when(service.getNumberOfSemesters(Mockito.<Long>any())).thenReturn(10);
        when(service.calculateEctsPointsForEachSemester(Mockito.<Long>any())).thenReturn(new HashMap<>());
        when(service.calculateHoursInEachSemesterFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new HashMap<>());
        when(service.fetchAllSubjectsFromFieldOfStudyGroupedBySemesters(Mockito.<Long>any())).thenReturn(new HashMap<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-subjects",
                fieldOfStudyController.getFieldOfStudySubjects(1L, request, new ConcurrentModel()));
        verify(service, atLeast(1)).fetchById(Mockito.<Long>any());
        verify(service).getNumberOfSemesters(Mockito.<Long>any());
        verify(service).calculateEctsPointsForEachSemester(Mockito.<Long>any());
        verify(service).calculateHoursInEachSemesterFromFieldOfStudy(Mockito.<Long>any());
        verify(service).fetchAllSubjectsFromFieldOfStudyGroupedBySemesters(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudySubjects(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetFieldOfStudySubjects10() {

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        when(service.getNumberOfSemesters(Mockito.<Long>any())).thenReturn(10);
        when(service.calculateEctsPointsForEachSemester(Mockito.<Long>any())).thenReturn(new HashMap<>());
        when(service.calculateHoursInEachSemesterFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new HashMap<>());
        when(service.fetchAllSubjectsFromFieldOfStudyGroupedBySemesters(Mockito.<Long>any())).thenReturn(new HashMap<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository2, new ModelMapper()), null);
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getFieldOfStudySubjects(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getFieldOfStudySubjects(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetFieldOfStudySubjects11() {

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        when(service.getNumberOfSemesters(Mockito.<Long>any())).thenReturn(10);
        when(service.calculateEctsPointsForEachSemester(Mockito.<Long>any())).thenReturn(new HashMap<>());
        when(service.calculateHoursInEachSemesterFromFieldOfStudy(Mockito.<Long>any())).thenReturn(new HashMap<>());
        when(service.fetchAllSubjectsFromFieldOfStudyGroupedBySemesters(Mockito.<Long>any())).thenReturn(new HashMap<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository2, new ModelMapper()), crumb);
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-subjects",
                fieldOfStudyController.getFieldOfStudySubjects(1L, request, new ConcurrentModel()));
        verify(service, atLeast(1)).fetchById(Mockito.<Long>any());
        verify(service).getNumberOfSemesters(Mockito.<Long>any());
        verify(service).calculateEctsPointsForEachSemester(Mockito.<Long>any());
        verify(service).calculateHoursInEachSemesterFromFieldOfStudy(Mockito.<Long>any());
        verify(service).fetchAllSubjectsFromFieldOfStudyGroupedBySemesters(Mockito.<Long>any());
        verify(crumb).getBreadcrumbs(Mockito.<String>any());
    }
    /**
     * Method under test: {@link FieldOfStudyController#getCreateFieldOfStudyForm(Model, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCreateFieldOfStudyForm4() {

        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, null, subjectService,
                new BreadcrumbService());
        ConcurrentModel model = new ConcurrentModel();
        fieldOfStudyController.getCreateFieldOfStudyForm(model, new MockHttpServletRequest());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getCreateFieldOfStudyForm(Model, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCreateFieldOfStudyForm6() {
        DepartmentService departmentService = mock(DepartmentService.class);
        when(departmentService.fetchAll()).thenReturn(new ArrayList<>());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository2, new ModelMapper()), null);
        ConcurrentModel model = new ConcurrentModel();
        fieldOfStudyController.getCreateFieldOfStudyForm(model, new MockHttpServletRequest());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getCreateFieldOfStudyForm(Model, HttpServletRequest)}
     */
    @Test
    void testGetCreateFieldOfStudyForm7() {
        DepartmentService departmentService = mock(DepartmentService.class);
        when(departmentService.fetchAll()).thenReturn(new ArrayList<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository2, new ModelMapper()), crumb);
        ConcurrentModel model = new ConcurrentModel();
        assertEquals("field-of-study/fieldOfStudy-create-form",
                fieldOfStudyController.getCreateFieldOfStudyForm(model, new MockHttpServletRequest()));
        verify(departmentService).fetchAll();
        verify(crumb).getBreadcrumbs(Mockito.<String>any());
        assertTrue(((FieldOfStudyDto) model.get("fieldOfStudy")).getSubjects().isEmpty());
        assertTrue(((FieldOfStudyDto) model.get("fieldOfStudy")).getStudents().isEmpty());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getCreateFieldOfStudyForm(Model, HttpServletRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCreateFieldOfStudyForm8() {
        DepartmentService departmentService = mock(DepartmentService.class);
        when(departmentService.fetchAll()).thenReturn(new ArrayList<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository2, new ModelMapper()), crumb);
        fieldOfStudyController.getCreateFieldOfStudyForm(new ConcurrentModel(), null);
    }

    /**
     * Method under test: {@link FieldOfStudyController#createFieldOfStudy(FieldOfStudyDto, MultipartFile, RedirectAttributes, BindingResult, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateFieldOfStudy() throws IOException {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.save(Mockito.<FieldOfStudy>any())).thenReturn(null);
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MockMultipartFile multipartFile = new MockMultipartFile("Name",
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        BindException result = new BindException("Target", "Object Name");

        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.createFieldOfStudy(dto, multipartFile, redirectAttributes, result, request,
                new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#createFieldOfStudy(FieldOfStudyDto, MultipartFile, RedirectAttributes, BindingResult, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateFieldOfStudy2() throws IOException {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.save(Mockito.<FieldOfStudy>any())).thenReturn(new FieldOfStudy());
        FieldOfStudyService service = new FieldOfStudyService(repository, null);

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MockMultipartFile multipartFile = new MockMultipartFile("Name",
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        BindException result = new BindException("Target", "Object Name");

        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.createFieldOfStudy(dto, multipartFile, redirectAttributes, result, request,
                new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#createFieldOfStudy(FieldOfStudyDto, MultipartFile, RedirectAttributes, BindingResult, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateFieldOfStudy3() throws IOException {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.save(Mockito.<FieldOfStudy>any())).thenReturn(new FieldOfStudy());
        ModelMapper mapper = mock(ModelMapper.class);
        when(mapper.map(Mockito.<Object>any(), Mockito.<Class<FieldOfStudy>>any())).thenReturn(null);
        FieldOfStudyService service = new FieldOfStudyService(repository, mapper);

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MockMultipartFile multipartFile = new MockMultipartFile("Name",
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        BindException result = new BindException("Target", "Object Name");

        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.createFieldOfStudy(dto, multipartFile, redirectAttributes, result, request,
                new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#createFieldOfStudy(FieldOfStudyDto, MultipartFile, RedirectAttributes, BindingResult, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateFieldOfStudy4() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.create(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        BindException result = new BindException("Target", "Object Name");

        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.createFieldOfStudy(dto, null, redirectAttributes, result, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#createFieldOfStudy(FieldOfStudyDto, MultipartFile, RedirectAttributes, BindingResult, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateFieldOfStudy5() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.create(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenThrow(new IOException("An error occurred"));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        BindException result = new BindException("Target", "Object Name");

        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.createFieldOfStudy(dto, multipartFile, redirectAttributes, result, request,
                new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#createFieldOfStudy(FieldOfStudyDto, MultipartFile, RedirectAttributes, BindingResult, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateFieldOfStudy6() throws IOException {

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.create(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(null);
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        BindException result = new BindException("Target", "Object Name");

        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.createFieldOfStudy(dto, multipartFile, redirectAttributes, result, request,
                new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#createFieldOfStudy(FieldOfStudyDto, MultipartFile, RedirectAttributes, BindingResult, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateFieldOfStudy7() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.create(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.createFieldOfStudy(dto, multipartFile, redirectAttributes, null, request,
                new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#createFieldOfStudy(FieldOfStudyDto, MultipartFile, RedirectAttributes, BindingResult, HttpServletRequest, Model)}
     */
    @Test
    void testCreateFieldOfStudy8() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.create(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findAll()).thenReturn(new ArrayList<>());
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("Object Name", "Default Message"));
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-create-form", fieldOfStudyController.createFieldOfStudy(dto,
                multipartFile, redirectAttributes, result, request, new ConcurrentModel()));
        verify(repository).findAll();
    }

    /**
     * Method under test: {@link FieldOfStudyController#createFieldOfStudy(FieldOfStudyDto, MultipartFile, RedirectAttributes, BindingResult, HttpServletRequest, Model)}
     */
    @Test
    void testCreateFieldOfStudy9() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.create(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);

        ArrayList<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findAll()).thenReturn(departmentList);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("Object Name", "Default Message"));
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-create-form", fieldOfStudyController.createFieldOfStudy(dto,
                multipartFile, redirectAttributes, result, request, new ConcurrentModel()));
        verify(repository).findAll();
    }

    /**
     * Method under test: {@link FieldOfStudyController#createFieldOfStudy(FieldOfStudyDto, MultipartFile, RedirectAttributes, BindingResult, HttpServletRequest, Model)}
     */
    @Test
    void testCreateFieldOfStudy10() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.create(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);

        ArrayList<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department());
        departmentList.add(new Department());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findAll()).thenReturn(departmentList);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("Object Name", "Default Message"));
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-create-form", fieldOfStudyController.createFieldOfStudy(dto,
                multipartFile, redirectAttributes, result, request, new ConcurrentModel()));
        verify(repository).findAll();
    }

    /**
     * Method under test: {@link FieldOfStudyController#createFieldOfStudy(FieldOfStudyDto, MultipartFile, RedirectAttributes, BindingResult, HttpServletRequest, Model)}
     */
    @Test
    void testCreateFieldOfStudy11() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.create(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentService departmentService = mock(DepartmentService.class);
        when(departmentService.fetchAll()).thenReturn(new ArrayList<>());
        SubjectRepository repository = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("Object Name", "Default Message"));
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-create-form", fieldOfStudyController.createFieldOfStudy(dto,
                multipartFile, redirectAttributes, result, request, new ConcurrentModel()));
        verify(departmentService).fetchAll();
    }

    /**
     * Method under test: {@link FieldOfStudyController#createFieldOfStudy(FieldOfStudyDto, MultipartFile, RedirectAttributes, BindingResult, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateFieldOfStudy12() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.create(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentService departmentService = mock(DepartmentService.class);
        when(departmentService.fetchAll()).thenReturn(new ArrayList<>());
        SubjectRepository repository = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository, new ModelMapper()), null);

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("Object Name", "Default Message"));
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.createFieldOfStudy(dto, multipartFile, redirectAttributes, result, request,
                new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#createFieldOfStudy(FieldOfStudyDto, MultipartFile, RedirectAttributes, BindingResult, HttpServletRequest, Model)}
     */
    @Test
    void testCreateFieldOfStudy13() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.create(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentService departmentService = mock(DepartmentService.class);
        when(departmentService.fetchAll()).thenReturn(new ArrayList<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        SubjectRepository repository = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository, new ModelMapper()), crumb);

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("Object Name", "Default Message"));
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-create-form", fieldOfStudyController.createFieldOfStudy(dto,
                multipartFile, redirectAttributes, result, request, new ConcurrentModel()));
        verify(departmentService).fetchAll();
        verify(crumb).getBreadcrumbs(Mockito.<String>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getEditFieldOfStudyForm(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetEditFieldOfStudyForm() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        when(repository2.findAll()).thenReturn(new ArrayList<>());
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-edit-form",
                fieldOfStudyController.getEditFieldOfStudyForm(1L, request, new ConcurrentModel()));
        verify(repository).findById(Mockito.<Long>any());
        verify(repository2).findAll();
    }

    /**
     * Method under test: {@link FieldOfStudyController#getEditFieldOfStudyForm(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetEditFieldOfStudyForm2() {

        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        when(repository2.findAll()).thenReturn(new ArrayList<>());
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getEditFieldOfStudyForm(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getEditFieldOfStudyForm(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetEditFieldOfStudyForm3() {

        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));
        FieldOfStudyService service = new FieldOfStudyService(repository, null);

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        when(repository2.findAll()).thenReturn(new ArrayList<>());
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getEditFieldOfStudyForm(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getEditFieldOfStudyForm(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetEditFieldOfStudyForm4() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        ModelMapper mapper = mock(ModelMapper.class);
        when(mapper.map(Mockito.<Object>any(), Mockito.<Class<FieldOfStudyDto>>any())).thenReturn(fieldOfStudyDto);
        FieldOfStudyService service = new FieldOfStudyService(repository, mapper);

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        when(repository2.findAll()).thenReturn(new ArrayList<>());
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-edit-form",
                fieldOfStudyController.getEditFieldOfStudyForm(1L, request, new ConcurrentModel()));
        verify(repository).findById(Mockito.<Long>any());
        verify(mapper).map(Mockito.<Object>any(), Mockito.<Class<FieldOfStudyDto>>any());
        verify(repository2).findAll();
    }

    /**
     * Method under test: {@link FieldOfStudyController#getEditFieldOfStudyForm(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetEditFieldOfStudyForm5() {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findAll()).thenReturn(new ArrayList<>());
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-edit-form",
                fieldOfStudyController.getEditFieldOfStudyForm(1L, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(repository).findAll();
    }

    /**
     * Method under test: {@link FieldOfStudyController#getEditFieldOfStudyForm(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetEditFieldOfStudyForm6() {

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);

        ArrayList<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findAll()).thenReturn(departmentList);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-edit-form",
                fieldOfStudyController.getEditFieldOfStudyForm(1L, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(repository).findAll();
    }

    /**
     * Method under test: {@link FieldOfStudyController#getEditFieldOfStudyForm(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetEditFieldOfStudyForm7() {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);

        ArrayList<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department());
        departmentList.add(new Department());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findAll()).thenReturn(departmentList);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-edit-form",
                fieldOfStudyController.getEditFieldOfStudyForm(1L, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(repository).findAll();
    }

    /**
     * Method under test: {@link FieldOfStudyController#getEditFieldOfStudyForm(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetEditFieldOfStudyForm8() {

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        SubjectRepository repository = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, null, subjectService,
                new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getEditFieldOfStudyForm(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getEditFieldOfStudyForm(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetEditFieldOfStudyForm9() {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        DepartmentService departmentService = mock(DepartmentService.class);
        when(departmentService.fetchAll()).thenReturn(new ArrayList<>());
        SubjectRepository repository = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-edit-form",
                fieldOfStudyController.getEditFieldOfStudyForm(1L, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(departmentService).fetchAll();
    }

    /**
     * Method under test: {@link FieldOfStudyController#getEditFieldOfStudyForm(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetEditFieldOfStudyForm10() {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        DepartmentService departmentService = mock(DepartmentService.class);
        when(departmentService.fetchAll()).thenReturn(new ArrayList<>());
        SubjectRepository repository = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository, new ModelMapper()), null);
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getEditFieldOfStudyForm(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getEditFieldOfStudyForm(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetEditFieldOfStudyForm11() {

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        DepartmentService departmentService = mock(DepartmentService.class);
        when(departmentService.fetchAll()).thenReturn(new ArrayList<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        SubjectRepository repository = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository, new ModelMapper()), crumb);
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-edit-form",
                fieldOfStudyController.getEditFieldOfStudyForm(1L, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(departmentService).fetchAll();
        verify(crumb).getBreadcrumbs(Mockito.<String>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editFieldOfStudy(FieldOfStudyDto, MultipartFile, BindingResult, RedirectAttributes, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditFieldOfStudy() throws IOException {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MockMultipartFile multipartFile = new MockMultipartFile("Name",
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

        BindException result = new BindException("Target", "Object Name");

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.editFieldOfStudy(dto, multipartFile, result, redirectAttributes, request,
                new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editFieldOfStudy(FieldOfStudyDto, MultipartFile, BindingResult, RedirectAttributes, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditFieldOfStudy2() throws IOException {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));
        FieldOfStudyService service = new FieldOfStudyService(repository, null);

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MockMultipartFile multipartFile = new MockMultipartFile("Name",
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

        BindException result = new BindException("Target", "Object Name");

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.editFieldOfStudy(dto, multipartFile, result, redirectAttributes, request,
                new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editFieldOfStudy(FieldOfStudyDto, MultipartFile, BindingResult, RedirectAttributes, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditFieldOfStudy3() throws IOException {

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.update(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        BindException result = new BindException("Target", "Object Name");

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.editFieldOfStudy(dto, null, result, redirectAttributes, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editFieldOfStudy(FieldOfStudyDto, MultipartFile, BindingResult, RedirectAttributes, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditFieldOfStudy4() throws IOException {

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.update(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenThrow(new IOException("An error occurred"));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");
        BindException result = new BindException("Target", "Object Name");

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.editFieldOfStudy(dto, multipartFile, result, redirectAttributes, request,
                new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editFieldOfStudy(FieldOfStudyDto, MultipartFile, BindingResult, RedirectAttributes, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditFieldOfStudy5() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.update(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(null);
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");
        BindException result = new BindException("Target", "Object Name");

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.editFieldOfStudy(dto, multipartFile, result, redirectAttributes, request,
                new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editFieldOfStudy(FieldOfStudyDto, MultipartFile, BindingResult, RedirectAttributes, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditFieldOfStudy6() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.update(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.editFieldOfStudy(dto, multipartFile, null, redirectAttributes, request,
                new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editFieldOfStudy(FieldOfStudyDto, MultipartFile, BindingResult, RedirectAttributes, HttpServletRequest, Model)}
     */
    @Test
    void testEditFieldOfStudy7() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.update(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findAll()).thenReturn(new ArrayList<>());
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("Object Name", "Default Message"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-edit-form", fieldOfStudyController.editFieldOfStudy(dto, multipartFile,
                result, redirectAttributes, request, new ConcurrentModel()));
        verify(repository).findAll();
    }

    /**
     * Method under test: {@link FieldOfStudyController#editFieldOfStudy(FieldOfStudyDto, MultipartFile, BindingResult, RedirectAttributes, HttpServletRequest, Model)}
     */
    @Test
    void testEditFieldOfStudy8() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.update(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);

        ArrayList<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findAll()).thenReturn(departmentList);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("Object Name", "Default Message"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-edit-form", fieldOfStudyController.editFieldOfStudy(dto, multipartFile,
                result, redirectAttributes, request, new ConcurrentModel()));
        verify(repository).findAll();
    }

    /**
     * Method under test: {@link FieldOfStudyController#editFieldOfStudy(FieldOfStudyDto, MultipartFile, BindingResult, RedirectAttributes, HttpServletRequest, Model)}
     */
    @Test
    void testEditFieldOfStudy9() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.update(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);

        ArrayList<Department> departmentList = new ArrayList<>();
        departmentList.add(new Department());
        departmentList.add(new Department());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findAll()).thenReturn(departmentList);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("Object Name", "Default Message"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-edit-form", fieldOfStudyController.editFieldOfStudy(dto, multipartFile,
                result, redirectAttributes, request, new ConcurrentModel()));
        verify(repository).findAll();
    }

    /**
     * Method under test: {@link FieldOfStudyController#editFieldOfStudy(FieldOfStudyDto, MultipartFile, BindingResult, RedirectAttributes, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditFieldOfStudy10() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.update(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        SubjectRepository repository = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, null, subjectService,
                new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("Object Name", "Default Message"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.editFieldOfStudy(dto, multipartFile, result, redirectAttributes, request,
                new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editFieldOfStudy(FieldOfStudyDto, MultipartFile, BindingResult, RedirectAttributes, HttpServletRequest, Model)}
     */
    @Test
    void testEditFieldOfStudy11() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.update(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentService departmentService = mock(DepartmentService.class);
        when(departmentService.fetchAll()).thenReturn(new ArrayList<>());
        SubjectRepository repository = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("Object Name", "Default Message"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-edit-form", fieldOfStudyController.editFieldOfStudy(dto, multipartFile,
                result, redirectAttributes, request, new ConcurrentModel()));
        verify(departmentService).fetchAll();
    }

    /**
     * Method under test: {@link FieldOfStudyController#editFieldOfStudy(FieldOfStudyDto, MultipartFile, BindingResult, RedirectAttributes, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditFieldOfStudy12() throws IOException {

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.update(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentService departmentService = mock(DepartmentService.class);
        when(departmentService.fetchAll()).thenReturn(new ArrayList<>());
        SubjectRepository repository = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository, new ModelMapper()), null);

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("Object Name", "Default Message"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.editFieldOfStudy(dto, multipartFile, result, redirectAttributes, request,
                new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editFieldOfStudy(FieldOfStudyDto, MultipartFile, BindingResult, RedirectAttributes, HttpServletRequest, Model)}
     */
    @Test
    void testEditFieldOfStudy13() throws IOException {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.update(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentService departmentService = mock(DepartmentService.class);
        when(departmentService.fetchAll()).thenReturn(new ArrayList<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        SubjectRepository repository = mock(SubjectRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                new SubjectService(repository, new ModelMapper()), crumb);

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        MultipartFile multipartFile = mock(MultipartFile.class);
        when(multipartFile.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
        when(multipartFile.getOriginalFilename()).thenReturn("foo.txt");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("Object Name", "Default Message"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-edit-form", fieldOfStudyController.editFieldOfStudy(dto, multipartFile,
                result, redirectAttributes, request, new ConcurrentModel()));
        verify(departmentService).fetchAll();
        verify(crumb).getBreadcrumbs(Mockito.<String>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getSubjectsForm(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSubjectsForm() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        when(repository2.findAllBySemester(Mockito.<Semester>any())).thenReturn(new ArrayList<>());
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        DepartmentRepository repository3 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getSubjectsForm(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getSubjectsForm(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetSubjectsForm2() {
        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.BACH);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(fieldOfStudy));
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        when(repository2.findAllBySemester(Mockito.<Semester>any())).thenReturn(new ArrayList<>());
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        DepartmentRepository repository3 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-subjects-edit-form",
                fieldOfStudyController.getSubjectsForm(1L, request, new ConcurrentModel()));
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(fieldOfStudy, atLeast(1)).getTitle();
        verify(fieldOfStudy, atLeast(1)).getLevelOfEducation();
        verify(fieldOfStudy, atLeast(1)).getMode();
        verify(fieldOfStudy, atLeast(1)).getDepartment();
        verify(fieldOfStudy, atLeast(1)).getId();
        verify(fieldOfStudy, atLeast(1)).getDescription();
        verify(fieldOfStudy, atLeast(1)).getImage();
        verify(fieldOfStudy, atLeast(1)).getName();
        verify(fieldOfStudy, atLeast(1)).getStudents();
        verify(fieldOfStudy, atLeast(1)).getSubjects();
        verify(repository2, atLeast(1)).findAllBySemester(Mockito.<Semester>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getSubjectsForm(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetSubjectsForm3() {


        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.ENG);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(fieldOfStudy));
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        when(repository2.findAllBySemester(Mockito.<Semester>any())).thenReturn(new ArrayList<>());
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        DepartmentRepository repository3 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-subjects-edit-form",
                fieldOfStudyController.getSubjectsForm(1L, request, new ConcurrentModel()));
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(fieldOfStudy, atLeast(1)).getTitle();
        verify(fieldOfStudy, atLeast(1)).getLevelOfEducation();
        verify(fieldOfStudy, atLeast(1)).getMode();
        verify(fieldOfStudy, atLeast(1)).getDepartment();
        verify(fieldOfStudy, atLeast(1)).getId();
        verify(fieldOfStudy, atLeast(1)).getDescription();
        verify(fieldOfStudy, atLeast(1)).getImage();
        verify(fieldOfStudy, atLeast(1)).getName();
        verify(fieldOfStudy, atLeast(1)).getStudents();
        verify(fieldOfStudy, atLeast(1)).getSubjects();
        verify(repository2, atLeast(1)).findAllBySemester(Mockito.<Semester>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getSubjectsForm(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetSubjectsForm4() {

        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.MGR);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(fieldOfStudy));
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        when(repository2.findAllBySemester(Mockito.<Semester>any())).thenReturn(new ArrayList<>());
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        DepartmentRepository repository3 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-subjects-edit-form",
                fieldOfStudyController.getSubjectsForm(1L, request, new ConcurrentModel()));
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(fieldOfStudy, atLeast(1)).getTitle();
        verify(fieldOfStudy, atLeast(1)).getLevelOfEducation();
        verify(fieldOfStudy, atLeast(1)).getMode();
        verify(fieldOfStudy, atLeast(1)).getDepartment();
        verify(fieldOfStudy, atLeast(1)).getId();
        verify(fieldOfStudy, atLeast(1)).getDescription();
        verify(fieldOfStudy, atLeast(1)).getImage();
        verify(fieldOfStudy, atLeast(1)).getName();
        verify(fieldOfStudy, atLeast(1)).getStudents();
        verify(fieldOfStudy, atLeast(1)).getSubjects();
        verify(repository2, atLeast(1)).findAllBySemester(Mockito.<Semester>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getSubjectsForm(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSubjectsForm5() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        when(repository2.findAllBySemester(Mockito.<Semester>any())).thenReturn(new ArrayList<>());
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        DepartmentRepository repository3 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getSubjectsForm(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getSubjectsForm(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSubjectsForm6() {
        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.BACH);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(fieldOfStudy));
        FieldOfStudyService service = new FieldOfStudyService(repository, null);

        SubjectRepository repository2 = mock(SubjectRepository.class);
        when(repository2.findAllBySemester(Mockito.<Semester>any())).thenReturn(new ArrayList<>());
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        DepartmentRepository repository3 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getSubjectsForm(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getSubjectsForm(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetSubjectsForm7() {
        FieldOfStudy fieldOfStudy = mock(FieldOfStudy.class);
        when(fieldOfStudy.getTitle()).thenReturn(AcademicTitle.BACH);
        when(fieldOfStudy.getLevelOfEducation()).thenReturn(LevelOfEducation.FIRST);
        when(fieldOfStudy.getMode()).thenReturn(ModeOfStudy.FT);
        when(fieldOfStudy.getDepartment()).thenReturn(new Department());
        when(fieldOfStudy.getId()).thenReturn(1L);
        when(fieldOfStudy.getDescription()).thenReturn("The characteristics of someone or something");
        when(fieldOfStudy.getImage()).thenReturn("Image");
        when(fieldOfStudy.getName()).thenReturn("Name");
        when(fieldOfStudy.getStudents()).thenReturn(new HashSet<>());
        when(fieldOfStudy.getSubjects()).thenReturn(new HashSet<>());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(fieldOfStudy));

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("crumbs");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("crumbs");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        ModelMapper mapper = mock(ModelMapper.class);
        when(mapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(fieldOfStudyDto);
        FieldOfStudyService service = new FieldOfStudyService(repository, mapper);

        SubjectRepository repository2 = mock(SubjectRepository.class);
        when(repository2.findAllBySemester(Mockito.<Semester>any())).thenReturn(new ArrayList<>());
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        DepartmentRepository repository3 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-subjects-edit-form",
                fieldOfStudyController.getSubjectsForm(1L, request, new ConcurrentModel()));
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(mapper, atLeast(1)).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
        verify(repository2, atLeast(1)).findAllBySemester(Mockito.<Semester>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getSubjectsForm(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetSubjectsForm8() {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        when(service.getNumberOfSemesters(Mockito.<Long>any())).thenReturn(10);
        SubjectRepository repository = mock(SubjectRepository.class);
        when(repository.findAllBySemester(Mockito.<Semester>any())).thenReturn(new ArrayList<>());
        SubjectService subjectService = new SubjectService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-subjects-edit-form",
                fieldOfStudyController.getSubjectsForm(1L, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(service).getNumberOfSemesters(Mockito.<Long>any());
        verify(repository, atLeast(1)).findAllBySemester(Mockito.<Semester>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getSubjectsForm(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSubjectsForm9() {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        when(service.getNumberOfSemesters(Mockito.<Long>any())).thenReturn(10);
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService, null,
                new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getSubjectsForm(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getSubjectsForm(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetSubjectsForm10() {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        when(service.getNumberOfSemesters(Mockito.<Long>any())).thenReturn(10);
        SubjectService subjectService = mock(SubjectService.class);
        when(subjectService.fetchAllGroupedBySemesters()).thenReturn(new HashMap<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-subjects-edit-form",
                fieldOfStudyController.getSubjectsForm(1L, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(service).getNumberOfSemesters(Mockito.<Long>any());
        verify(subjectService).fetchAllGroupedBySemesters();
    }

    /**
     * Method under test: {@link FieldOfStudyController#getSubjectsForm(Long, HttpServletRequest, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSubjectsForm11() {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        when(service.getNumberOfSemesters(Mockito.<Long>any())).thenReturn(10);
        SubjectService subjectService = mock(SubjectService.class);
        when(subjectService.fetchAllGroupedBySemesters()).thenReturn(new HashMap<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service,
                new DepartmentService(repository, new ModelMapper()), subjectService, null);
        MockHttpServletRequest request = new MockHttpServletRequest();
        fieldOfStudyController.getSubjectsForm(1L, request, new ConcurrentModel());
    }

    /**
     * Method under test: {@link FieldOfStudyController#getSubjectsForm(Long, HttpServletRequest, Model)}
     */
    @Test
    void testGetSubjectsForm12() {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        when(service.getNumberOfSemesters(Mockito.<Long>any())).thenReturn(10);
        SubjectService subjectService = mock(SubjectService.class);
        when(subjectService.fetchAllGroupedBySemesters()).thenReturn(new HashMap<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service,
                new DepartmentService(repository, new ModelMapper()), subjectService, crumb);
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("field-of-study/fieldOfStudy-subjects-edit-form",
                fieldOfStudyController.getSubjectsForm(1L, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(service).getNumberOfSemesters(Mockito.<Long>any());
        verify(subjectService).fetchAllGroupedBySemesters();
        verify(crumb).getBreadcrumbs(Mockito.<String>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editSubjects(FieldOfStudyDto, RedirectAttributes)}
     */
    @Test
    void testEditSubjects() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.save(Mockito.<FieldOfStudy>any())).thenReturn(new FieldOfStudy());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        assertEquals("redirect:/dashboard/fields-of-study/1/subjects",
                fieldOfStudyController.editSubjects(dto, new RedirectAttributesModelMap()));
        verify(repository).save(Mockito.<FieldOfStudy>any());
        verify(repository).findById(Mockito.<Long>any());
        assertEquals(1, dto.getDepartment().getFieldsOfStudy().size());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editSubjects(FieldOfStudyDto, RedirectAttributes)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditSubjects2() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.save(Mockito.<FieldOfStudy>any())).thenReturn(null);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        fieldOfStudyController.editSubjects(dto, new RedirectAttributesModelMap());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editSubjects(FieldOfStudyDto, RedirectAttributes)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditSubjects3() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.save(Mockito.<FieldOfStudy>any())).thenReturn(new FieldOfStudy());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        fieldOfStudyController.editSubjects(dto, new RedirectAttributesModelMap());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editSubjects(FieldOfStudyDto, RedirectAttributes)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditSubjects4() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.save(Mockito.<FieldOfStudy>any())).thenReturn(new FieldOfStudy());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));
        FieldOfStudyService service = new FieldOfStudyService(repository, null);

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        fieldOfStudyController.editSubjects(dto, new RedirectAttributesModelMap());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editSubjects(FieldOfStudyDto, RedirectAttributes)}
     */
    @Test
    void testEditSubjects5() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.save(Mockito.<FieldOfStudy>any())).thenReturn(new FieldOfStudy());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        ModelMapper mapper = mock(ModelMapper.class);
        when(mapper.map(Mockito.<Object>any(), Mockito.<Class<FieldOfStudyDto>>any())).thenReturn(fieldOfStudyDto);
        doNothing().when(mapper).map(Mockito.<Object>any(), Mockito.<Object>any());
        FieldOfStudyService service = new FieldOfStudyService(repository, mapper);

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        assertEquals("redirect:/dashboard/fields-of-study/1/subjects",
                fieldOfStudyController.editSubjects(dto, new RedirectAttributesModelMap()));
        verify(repository).save(Mockito.<FieldOfStudy>any());
        verify(repository).findById(Mockito.<Long>any());
        verify(mapper).map(Mockito.<Object>any(), Mockito.<Class<FieldOfStudyDto>>any());
        verify(mapper).map(Mockito.<Object>any(), Mockito.<Object>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#editSubjects(FieldOfStudyDto, RedirectAttributes)}
     */
    @Test
    void testEditSubjects6() {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.updateSubjects(Mockito.<FieldOfStudyDto>any())).thenReturn(fieldOfStudyDto);
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());

        FieldOfStudyDto dto = new FieldOfStudyDto();
        dto.setDepartment(new Department());
        dto.setDescription("The characteristics of someone or something");
        dto.setId(1L);
        dto.setImage("Image");
        dto.setLevelOfEducation(LevelOfEducation.FIRST);
        dto.setMode(ModeOfStudy.FT);
        dto.setName("Name");
        dto.setStudents(new HashSet<>());
        dto.setSubjects(new HashSet<>());
        dto.setTitle(AcademicTitle.BACH);
        assertEquals("redirect:/dashboard/fields-of-study/1/subjects",
                fieldOfStudyController.editSubjects(dto, new RedirectAttributesModelMap()));
        verify(service).updateSubjects(Mockito.<FieldOfStudyDto>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#deleteFieldOfStudy(Long, RedirectAttributes)}
     */
    @Test
    void testDeleteFieldOfStudy() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        doNothing().when(repository).delete(Mockito.<FieldOfStudy>any());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        assertEquals(FieldOfStudyController.REDIRECT_DASHBOARD_FIELDS_OF_STUDY,
                fieldOfStudyController.deleteFieldOfStudy(1L, new RedirectAttributesModelMap()));
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(repository).delete(Mockito.<FieldOfStudy>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#deleteFieldOfStudy(Long, RedirectAttributes)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteFieldOfStudy2() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        doNothing().when(repository).delete(Mockito.<FieldOfStudy>any());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        FieldOfStudyService service = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        fieldOfStudyController.deleteFieldOfStudy(1L, new RedirectAttributesModelMap());
    }

    /**
     * Method under test: {@link FieldOfStudyController#deleteFieldOfStudy(Long, RedirectAttributes)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteFieldOfStudy3() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        doNothing().when(repository).delete(Mockito.<FieldOfStudy>any());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));
        FieldOfStudyService service = new FieldOfStudyService(repository, null);

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        fieldOfStudyController.deleteFieldOfStudy(1L, new RedirectAttributesModelMap());
    }

    /**
     * Method under test: {@link FieldOfStudyController#deleteFieldOfStudy(Long, RedirectAttributes)}
     */
    @Test
    void testDeleteFieldOfStudy4() {
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        doNothing().when(repository).delete(Mockito.<FieldOfStudy>any());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new FieldOfStudy()));

        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        ModelMapper mapper = mock(ModelMapper.class);
        when(mapper.map(Mockito.<Object>any(), Mockito.<Class<FieldOfStudyDto>>any())).thenReturn(fieldOfStudyDto);
        FieldOfStudyService service = new FieldOfStudyService(repository, mapper);

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository2, new ModelMapper());

        SubjectRepository repository3 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository3, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        assertEquals(FieldOfStudyController.REDIRECT_DASHBOARD_FIELDS_OF_STUDY,
                fieldOfStudyController.deleteFieldOfStudy(1L, new RedirectAttributesModelMap()));
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(repository).delete(Mockito.<FieldOfStudy>any());
        verify(mapper).map(Mockito.<Object>any(), Mockito.<Class<FieldOfStudyDto>>any());
    }

    /**
     * Method under test: {@link FieldOfStudyController#deleteFieldOfStudy(Long, RedirectAttributes)}
     */
    @Test
    void testDeleteFieldOfStudy5() {
        FieldOfStudyDto fieldOfStudyDto = new FieldOfStudyDto();
        fieldOfStudyDto.setDepartment(new Department());
        fieldOfStudyDto.setDescription("The characteristics of someone or something");
        fieldOfStudyDto.setId(1L);
        fieldOfStudyDto.setImage("Image");
        fieldOfStudyDto.setLevelOfEducation(LevelOfEducation.FIRST);
        fieldOfStudyDto.setMode(ModeOfStudy.FT);
        fieldOfStudyDto.setName("Name");
        fieldOfStudyDto.setStudents(new HashSet<>());
        fieldOfStudyDto.setSubjects(new HashSet<>());
        fieldOfStudyDto.setTitle(AcademicTitle.BACH);
        FieldOfStudyService service = mock(FieldOfStudyService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(fieldOfStudyDto);
        doNothing().when(service).remove(Mockito.<Long>any());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService departmentService = new DepartmentService(repository, new ModelMapper());

        SubjectRepository repository2 = mock(SubjectRepository.class);
        SubjectService subjectService = new SubjectService(repository2, new ModelMapper());

        FieldOfStudyController fieldOfStudyController = new FieldOfStudyController(service, departmentService,
                subjectService, new BreadcrumbService());
        assertEquals(FieldOfStudyController.REDIRECT_DASHBOARD_FIELDS_OF_STUDY,
                fieldOfStudyController.deleteFieldOfStudy(1L, new RedirectAttributesModelMap()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(service).remove(Mockito.<Long>any());
    }
}

