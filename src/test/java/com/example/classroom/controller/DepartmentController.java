package com.example.classroom.controller;

import com.example.classroom.breadcrumb.BreadcrumbService;
import com.example.classroom.dto.DepartmentDto;
import com.example.classroom.model.Department;
import com.example.classroom.model.FieldOfStudy;
import com.example.classroom.model.Teacher;
import com.example.classroom.repository.DepartmentRepository;
import com.example.classroom.repository.FieldOfStudyRepository;
import com.example.classroom.repository.TeacherRepository;
import com.example.classroom.service.DepartmentService;
import com.example.classroom.service.FieldOfStudyService;
import com.example.classroom.service.TeacherService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepartmentControllerTest {





    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllDepartments4() {
        TeacherRepository repository = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository2, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(null, teacherService, fieldOfStudyService,
                new BreadcrumbService());
        ConcurrentModel model = new ConcurrentModel();
        departmentController.getAllDepartments(model, new MockHttpServletRequest());
    }


    @Test

    void testGetAllDepartments6() {
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchAll()).thenReturn(new ArrayList<>());
        TeacherRepository repository = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        DepartmentController departmentController = new DepartmentController(service, teacherService,
                new FieldOfStudyService(repository2, new ModelMapper()), null);
        ConcurrentModel model = new ConcurrentModel();
        departmentController.getAllDepartments(model, new MockHttpServletRequest());
    }

    @Test
    void testGetAllDepartments7() {
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchAll()).thenReturn(new ArrayList<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        TeacherRepository repository = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        DepartmentController departmentController = new DepartmentController(service, teacherService,
                new FieldOfStudyService(repository2, new ModelMapper()), crumb);
        ConcurrentModel model = new ConcurrentModel();
        assertEquals("department/all-departments",
                departmentController.getAllDepartments(model, new MockHttpServletRequest()));
        verify(service).fetchAll();
        verify(crumb).getBreadcrumbs(Mockito.<String>any());
    }

    @Test
    void testGetAllDepartments8() {
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchAll()).thenReturn(new ArrayList<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        TeacherRepository repository = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        DepartmentController departmentController = new DepartmentController(service, teacherService,
                new FieldOfStudyService(repository2, new ModelMapper()), crumb);
        departmentController.getAllDepartments(new ConcurrentModel(), null);
    }

    @Test
    void testGetDepartment() {
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new Department()));
        DepartmentService service = new DepartmentService(repository, new ModelMapper());

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-view",
                departmentController.getDepartment(1L, request, new ConcurrentModel()));
        verify(repository).findById(Mockito.<Long>any());
    }

    @Test
    void testGetDepartment2() {


        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        DepartmentService service = new DepartmentService(repository, new ModelMapper());

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        departmentController.getDepartment(1L, request, new ConcurrentModel());
    }

    @Test
    void testGetDepartment3() {


        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new Department()));
        DepartmentService service = new DepartmentService(repository, null);

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        departmentController.getDepartment(1L, request, new ConcurrentModel());
    }

    @Test
    void testGetDepartment4() {
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new Department()));

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        ModelMapper mapper = mock(ModelMapper.class);
        when(mapper.map(Mockito.<Object>any(), Mockito.<Class<DepartmentDto>>any())).thenReturn(departmentDto);
        DepartmentService service = new DepartmentService(repository, mapper);

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-view",
                departmentController.getDepartment(1L, request, new ConcurrentModel()));
        verify(repository).findById(Mockito.<Long>any());
        verify(mapper).map(Mockito.<Object>any(), Mockito.<Class<DepartmentDto>>any());
    }

    @Test
    void testGetDepartment5() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto);
        TeacherRepository repository = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository2, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-view",
                departmentController.getDepartment(1L, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetDepartment6() {


        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto);
        TeacherRepository repository = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        DepartmentController departmentController = new DepartmentController(service, teacherService,
                new FieldOfStudyService(repository2, new ModelMapper()), null);
        MockHttpServletRequest request = new MockHttpServletRequest();
        departmentController.getDepartment(1L, request, new ConcurrentModel());
    }

    @Test
    void testGetDepartment7() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto);
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        TeacherRepository repository = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        DepartmentController departmentController = new DepartmentController(service, teacherService,
                new FieldOfStudyService(repository2, new ModelMapper()), crumb);
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-view",
                departmentController.getDepartment(1L, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(crumb).getBreadcrumbs(Mockito.<String>any());
    }



    @Test

    void testGetNewDepartmentForm4() {

        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentRepository repository2 = mock(DepartmentRepository.class);
        DepartmentService service = new DepartmentService(repository2, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, null, fieldOfStudyService,
                new BreadcrumbService());
        ConcurrentModel model = new ConcurrentModel();
        departmentController.getNewDepartmentForm(model, new MockHttpServletRequest());
    }

    @Test
    void testGetNewDepartmentForm8() {
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentService service = new DepartmentService(repository, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, null,
                new BreadcrumbService());
        ConcurrentModel model = new ConcurrentModel();
        departmentController.getNewDepartmentForm(model, new MockHttpServletRequest());
    }


    @Test
    void testGetNewDepartmentForm10() {

        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = mock(FieldOfStudyService.class);
        when(fieldOfStudyService.fetchAllWithNoDepartment()).thenReturn(new ArrayList<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentController departmentController = new DepartmentController(
                new DepartmentService(repository, new ModelMapper()), teacherService, fieldOfStudyService, null);
        ConcurrentModel model = new ConcurrentModel();
        departmentController.getNewDepartmentForm(model, new MockHttpServletRequest());
    }

    @Test
    void testGetNewDepartmentForm11() {
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = mock(FieldOfStudyService.class);
        when(fieldOfStudyService.fetchAllWithNoDepartment()).thenReturn(new ArrayList<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentController departmentController = new DepartmentController(
                new DepartmentService(repository, new ModelMapper()), teacherService, fieldOfStudyService, crumb);
        ConcurrentModel model = new ConcurrentModel();
        assertEquals("department/department-create-form",
                departmentController.getNewDepartmentForm(model, new MockHttpServletRequest()));
        verify(teacherService).fetchAll();
        verify(fieldOfStudyService).fetchAllWithNoDepartment();
        verify(crumb).getBreadcrumbs(Mockito.<String>any());
        assertTrue(((DepartmentDto) model.get("department")).getFieldsOfStudy().isEmpty());
    }

    @Test
    void testGetNewDepartmentForm12() {


        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = mock(FieldOfStudyService.class);
        when(fieldOfStudyService.fetchAllWithNoDepartment()).thenReturn(new ArrayList<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        DepartmentRepository repository = mock(DepartmentRepository.class);
        DepartmentController departmentController = new DepartmentController(
                new DepartmentService(repository, new ModelMapper()), teacherService, fieldOfStudyService, crumb);
        departmentController.getNewDepartmentForm(new ConcurrentModel(), null);
    }

    @Test
    void testCreateDepartment() {
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.save(Mockito.<Department>any())).thenReturn(new Department());
        DepartmentService service = new DepartmentService(repository, new ModelMapper());

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");
        BindException result = new BindException("Target", "Object Name");

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals(DepartmentController.REDIRECT_DASHBOARD_DEPARTMENTS,
                departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(repository).save(Mockito.<Department>any());
        Teacher dean = dto.getDean();
        Department department = dean.getDepartment();
        assertEquals("42 Main St", department.getAddress());
        assertEquals("42", department.getTelNumber());
        assertEquals("Name", department.getName());
        assertEquals(1L, department.getId().longValue());
        assertTrue(department.getFieldsOfStudy().isEmpty());
        assertSame(dean, department.getDean());
    }

    @Test
    void testCreateDepartment2() {


        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.save(Mockito.<Department>any())).thenReturn(null);
        DepartmentService service = new DepartmentService(repository, new ModelMapper());

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");
        BindException result = new BindException("Target", "Object Name");

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel());
    }

    @Test
    void testCreateDepartment3() {

        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.save(Mockito.<Department>any())).thenReturn(new Department());
        DepartmentService service = new DepartmentService(repository, null);

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");
        BindException result = new BindException("Target", "Object Name");

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel());
    }

    @Test
    void testCreateDepartment4() {
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.save(Mockito.<Department>any())).thenReturn(new Department());
        ModelMapper mapper = mock(ModelMapper.class);
        when(mapper.map(Mockito.<Object>any(), Mockito.<Class<Department>>any())).thenReturn(null);
        DepartmentService service = new DepartmentService(repository, mapper);

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");
        BindException result = new BindException("Target", "Object Name");

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel());
    }

    @Test
    void testCreateDepartment5() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.create(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherRepository repository = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository2, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");
        BindException result = new BindException("Target", "Object Name");

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals(DepartmentController.REDIRECT_DASHBOARD_DEPARTMENTS,
                departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(service).create(Mockito.<DepartmentDto>any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testCreateDepartment6() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.create(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherRepository repository = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository2, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        departmentController.createDepartment(dto, null, redirectAttributes, request, new ConcurrentModel());
    }

    @Test
    void testCreateDepartment7() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.create(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherRepository repository = mock(TeacherRepository.class);
        when(repository.findAll()).thenReturn(new ArrayList<>());
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        when(repository2.findAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository2, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-create-form",
                departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(repository).findAll();
        verify(repository2).findAll();
    }

    @Test
    void testCreateDepartment8() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.create(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);

        ArrayList<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher());
        TeacherRepository repository = mock(TeacherRepository.class);
        when(repository.findAll()).thenReturn(teacherList);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        when(repository2.findAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository2, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-create-form",
                departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(repository).findAll();
        verify(repository2).findAll();
    }

    @Test
    void testCreateDepartment9() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.create(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);

        ArrayList<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher());
        teacherList.add(new Teacher());
        TeacherRepository repository = mock(TeacherRepository.class);
        when(repository.findAll()).thenReturn(teacherList);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        when(repository2.findAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository2, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-create-form",
                departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(repository).findAll();
        verify(repository2).findAll();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testCreateDepartment10() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.create(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, null, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel());
    }

    @Test
    void testCreateDepartment11() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.create(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-create-form",
                departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(teacherService).fetchAll();
        verify(repository).findAll();
    }

    @Test
    void testCreateDepartment12() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.create(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());

        ArrayList<FieldOfStudy> fieldOfStudyList = new ArrayList<>();
        fieldOfStudyList.add(new FieldOfStudy());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAll()).thenReturn(fieldOfStudyList);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-create-form",
                departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(teacherService).fetchAll();
        verify(repository).findAll();
    }

    @Test
    void testCreateDepartment13() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.create(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());

        ArrayList<FieldOfStudy> fieldOfStudyList = new ArrayList<>();
        fieldOfStudyList.add(new FieldOfStudy());
        fieldOfStudyList.add(new FieldOfStudy());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAll()).thenReturn(fieldOfStudyList);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-create-form",
                departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(teacherService).fetchAll();
        verify(repository).findAll();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testCreateDepartment14() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.create(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        DepartmentController departmentController = new DepartmentController(service, teacherService, null,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel());
    }

    @Test
    void testCreateDepartment15() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.create(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = mock(FieldOfStudyService.class);
        when(fieldOfStudyService.fetchAllWithNoDepartment()).thenReturn(new ArrayList<>());
        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-create-form",
                departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(teacherService).fetchAll();
        verify(fieldOfStudyService).fetchAllWithNoDepartment();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testCreateDepartment16() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.create(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = mock(FieldOfStudyService.class);
        when(fieldOfStudyService.fetchAllWithNoDepartment()).thenReturn(new ArrayList<>());
        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                null);

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel());
    }

    @Test
    void testCreateDepartment17() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.create(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = mock(FieldOfStudyService.class);
        when(fieldOfStudyService.fetchAllWithNoDepartment()).thenReturn(new ArrayList<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                crumb);

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-create-form",
                departmentController.createDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(teacherService).fetchAll();
        verify(fieldOfStudyService).fetchAllWithNoDepartment();
        verify(crumb).getBreadcrumbs(Mockito.<String>any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetEditDepartmentForm2() {
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        DepartmentService service = new DepartmentService(repository, new ModelMapper());

        TeacherRepository repository2 = mock(TeacherRepository.class);
        when(repository2.findAll()).thenReturn(new ArrayList<>());
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        when(repository3.findAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());
        ConcurrentModel model = new ConcurrentModel();
        departmentController.getEditDepartmentForm(1L, model, new MockHttpServletRequest());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetEditDepartmentForm3() {
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new Department()));
        DepartmentService service = new DepartmentService(repository, null);

        TeacherRepository repository2 = mock(TeacherRepository.class);
        when(repository2.findAll()).thenReturn(new ArrayList<>());
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        when(repository3.findAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());
        ConcurrentModel model = new ConcurrentModel();
        departmentController.getEditDepartmentForm(1L, model, new MockHttpServletRequest());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetEditDepartmentForm8() {

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto);
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, null, fieldOfStudyService,
                new BreadcrumbService());
        ConcurrentModel model = new ConcurrentModel();
        departmentController.getEditDepartmentForm(1L, model, new MockHttpServletRequest());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetEditDepartmentForm12() {

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        DepartmentController departmentController = new DepartmentController(service, teacherService, null,
                new BreadcrumbService());
        ConcurrentModel model = new ConcurrentModel();
        departmentController.getEditDepartmentForm(1L, model, new MockHttpServletRequest());
    }
    @Test
    @Disabled("TODO: Complete this test")
    void testGetEditDepartmentForm14() {

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = mock(FieldOfStudyService.class);
        when(fieldOfStudyService.fetchAllWithGivenDepartmentDtoOrNoDepartment(Mockito.<DepartmentDto>any()))
                .thenReturn(new ArrayList<>());
        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                null);
        ConcurrentModel model = new ConcurrentModel();
        departmentController.getEditDepartmentForm(1L, model, new MockHttpServletRequest());
    }

    @Test
    void testGetEditDepartmentForm15() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = mock(FieldOfStudyService.class);
        when(fieldOfStudyService.fetchAllWithGivenDepartmentDtoOrNoDepartment(Mockito.<DepartmentDto>any()))
                .thenReturn(new ArrayList<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                crumb);
        ConcurrentModel model = new ConcurrentModel();
        assertEquals("department/department-edit-form",
                departmentController.getEditDepartmentForm(1L, model, new MockHttpServletRequest()));
        verify(service, atLeast(1)).fetchById(Mockito.<Long>any());
        verify(teacherService).fetchAll();
        verify(fieldOfStudyService).fetchAllWithGivenDepartmentDtoOrNoDepartment(Mockito.<DepartmentDto>any());
        verify(crumb).getBreadcrumbs(Mockito.<String>any());
    }

    @Test
    void testEditDepartment() {
        DepartmentRepository repository = mock(DepartmentRepository.class);
        Department department = new Department();
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(department));
        DepartmentService service = new DepartmentService(repository, new ModelMapper());

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");
        BindException result = new BindException("Target", "Object Name");

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals(DepartmentController.REDIRECT_DASHBOARD_DEPARTMENTS,
                departmentController.editDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(repository).findById(Mockito.<Long>any());
        Teacher dean = dto.getDean();
        Department department2 = dean.getDepartment();
        assertSame(department, department2);
        assertEquals("42 Main St", department2.getAddress());
        assertEquals("42", department2.getTelNumber());
        assertEquals("Name", department2.getName());
        assertEquals(1L, department2.getId().longValue());
        assertTrue(department2.getFieldsOfStudy().isEmpty());
        assertSame(dean, department2.getDean());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testEditDepartment2() {
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        DepartmentService service = new DepartmentService(repository, new ModelMapper());

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");
        BindException result = new BindException("Target", "Object Name");

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        departmentController.editDepartment(dto, result, redirectAttributes, request, new ConcurrentModel());
    }

    @Test
    void testEditDepartment3() {
        DepartmentRepository repository = mock(DepartmentRepository.class);
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new Department()));

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        ModelMapper mapper = mock(ModelMapper.class);
        when(mapper.map(Mockito.<Object>any(), Mockito.<Class<DepartmentDto>>any())).thenReturn(departmentDto);
        doNothing().when(mapper).map(Mockito.<Object>any(), Mockito.<Object>any());
        DepartmentService service = new DepartmentService(repository, mapper);

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");
        BindException result = new BindException("Target", "Object Name");

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals(DepartmentController.REDIRECT_DASHBOARD_DEPARTMENTS,
                departmentController.editDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(repository).findById(Mockito.<Long>any());
        verify(mapper).map(Mockito.<Object>any(), Mockito.<Class<DepartmentDto>>any());
        verify(mapper).map(Mockito.<Object>any(), Mockito.<Object>any());
    }

    @Test
    void testEditDepartment4() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.update(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherRepository repository = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository2, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");
        BindException result = new BindException("Target", "Object Name");

        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals(DepartmentController.REDIRECT_DASHBOARD_DEPARTMENTS,
                departmentController.editDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(service).update(Mockito.<DepartmentDto>any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testEditDepartment5() {

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.update(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherRepository repository = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository2, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        departmentController.editDepartment(dto, null, redirectAttributes, request, new ConcurrentModel());
    }

    @Test
    void testEditDepartment6() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");

        DepartmentDto departmentDto2 = new DepartmentDto();
        departmentDto2.setAddress("42 Main St");
        departmentDto2.setDean(new Teacher());
        departmentDto2.setFieldsOfStudy(new HashSet<>());
        departmentDto2.setId(1L);
        departmentDto2.setName("Name");
        departmentDto2.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto2);
        when(service.update(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherRepository repository = mock(TeacherRepository.class);
        when(repository.findAll()).thenReturn(new ArrayList<>());
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        when(repository2.findAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository2, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-edit-form",
                departmentController.editDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(repository).findAll();
        verify(repository2, atLeast(1)).findAll();
    }

    @Test
    void testEditDepartment7() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");

        DepartmentDto departmentDto2 = new DepartmentDto();
        departmentDto2.setAddress("42 Main St");
        departmentDto2.setDean(new Teacher());
        departmentDto2.setFieldsOfStudy(new HashSet<>());
        departmentDto2.setId(1L);
        departmentDto2.setName("Name");
        departmentDto2.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto2);
        when(service.update(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);

        ArrayList<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher());
        TeacherRepository repository = mock(TeacherRepository.class);
        when(repository.findAll()).thenReturn(teacherList);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        when(repository2.findAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository2, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-edit-form",
                departmentController.editDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(repository).findAll();
        verify(repository2, atLeast(1)).findAll();
    }

    @Test
    void testEditDepartment8() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");

        DepartmentDto departmentDto2 = new DepartmentDto();
        departmentDto2.setAddress("42 Main St");
        departmentDto2.setDean(new Teacher());
        departmentDto2.setFieldsOfStudy(new HashSet<>());
        departmentDto2.setId(1L);
        departmentDto2.setName("Name");
        departmentDto2.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto2);
        when(service.update(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);

        ArrayList<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher());
        teacherList.add(new Teacher());
        TeacherRepository repository = mock(TeacherRepository.class);
        when(repository.findAll()).thenReturn(teacherList);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        when(repository2.findAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository2, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-edit-form",
                departmentController.editDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(repository).findAll();
        verify(repository2, atLeast(1)).findAll();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testEditDepartment9() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");

        DepartmentDto departmentDto2 = new DepartmentDto();
        departmentDto2.setAddress("42 Main St");
        departmentDto2.setDean(new Teacher());
        departmentDto2.setFieldsOfStudy(new HashSet<>());
        departmentDto2.setId(1L);
        departmentDto2.setName("Name");
        departmentDto2.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto2);
        when(service.update(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, null, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        departmentController.editDepartment(dto, result, redirectAttributes, request, new ConcurrentModel());
    }

    @Test
    void testEditDepartment10() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");

        DepartmentDto departmentDto2 = new DepartmentDto();
        departmentDto2.setAddress("42 Main St");
        departmentDto2.setDean(new Teacher());
        departmentDto2.setFieldsOfStudy(new HashSet<>());
        departmentDto2.setId(1L);
        departmentDto2.setName("Name");
        departmentDto2.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto2);
        when(service.update(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-edit-form",
                departmentController.editDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(teacherService).fetchAll();
        verify(repository, atLeast(1)).findAll();
    }

    @Test
    void testEditDepartment11() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");

        DepartmentDto departmentDto2 = new DepartmentDto();
        departmentDto2.setAddress("42 Main St");
        departmentDto2.setDean(new Teacher());
        departmentDto2.setFieldsOfStudy(new HashSet<>());
        departmentDto2.setId(1L);
        departmentDto2.setName("Name");
        departmentDto2.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto2);
        when(service.update(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());

        ArrayList<FieldOfStudy> fieldOfStudyList = new ArrayList<>();
        fieldOfStudyList.add(new FieldOfStudy());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAll()).thenReturn(fieldOfStudyList);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-edit-form",
                departmentController.editDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(teacherService).fetchAll();
        verify(repository, atLeast(1)).findAll();
    }

    @Test
    void testEditDepartment12() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");

        DepartmentDto departmentDto2 = new DepartmentDto();
        departmentDto2.setAddress("42 Main St");
        departmentDto2.setDean(new Teacher());
        departmentDto2.setFieldsOfStudy(new HashSet<>());
        departmentDto2.setId(1L);
        departmentDto2.setName("Name");
        departmentDto2.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto2);
        when(service.update(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());

        ArrayList<FieldOfStudy> fieldOfStudyList = new ArrayList<>();
        fieldOfStudyList.add(new FieldOfStudy());
        fieldOfStudyList.add(new FieldOfStudy());
        FieldOfStudyRepository repository = mock(FieldOfStudyRepository.class);
        when(repository.findAll()).thenReturn(fieldOfStudyList);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-edit-form",
                departmentController.editDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(teacherService).fetchAll();
        verify(repository, atLeast(1)).findAll();
    }

    @Test
    void testEditDepartment13() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");

        DepartmentDto departmentDto2 = new DepartmentDto();
        departmentDto2.setAddress("42 Main St");
        departmentDto2.setDean(new Teacher());
        departmentDto2.setFieldsOfStudy(new HashSet<>());
        departmentDto2.setId(1L);
        departmentDto2.setName("Name");
        departmentDto2.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto2);
        when(service.update(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = mock(FieldOfStudyService.class);
        when(fieldOfStudyService.fetchAllWithGivenDepartmentDtoOrNoDepartment(Mockito.<DepartmentDto>any()))
                .thenReturn(new ArrayList<>());
        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-edit-form",
                departmentController.editDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(teacherService).fetchAll();
        verify(fieldOfStudyService).fetchAllWithGivenDepartmentDtoOrNoDepartment(Mockito.<DepartmentDto>any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testEditDepartment14() {

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");

        DepartmentDto departmentDto2 = new DepartmentDto();
        departmentDto2.setAddress("42 Main St");
        departmentDto2.setDean(new Teacher());
        departmentDto2.setFieldsOfStudy(new HashSet<>());
        departmentDto2.setId(1L);
        departmentDto2.setName("Name");
        departmentDto2.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto2);
        when(service.update(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = mock(FieldOfStudyService.class);
        when(fieldOfStudyService.fetchAllWithGivenDepartmentDtoOrNoDepartment(Mockito.<DepartmentDto>any()))
                .thenReturn(new ArrayList<>());
        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                null);

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        departmentController.editDepartment(dto, result, redirectAttributes, request, new ConcurrentModel());
    }

    @Test
    void testEditDepartment15() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");

        DepartmentDto departmentDto2 = new DepartmentDto();
        departmentDto2.setAddress("42 Main St");
        departmentDto2.setDean(new Teacher());
        departmentDto2.setFieldsOfStudy(new HashSet<>());
        departmentDto2.setId(1L);
        departmentDto2.setName("Name");
        departmentDto2.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto2);
        when(service.update(Mockito.<DepartmentDto>any())).thenReturn(departmentDto);
        TeacherService teacherService = mock(TeacherService.class);
        when(teacherService.fetchAll()).thenReturn(new ArrayList<>());
        FieldOfStudyService fieldOfStudyService = mock(FieldOfStudyService.class);
        when(fieldOfStudyService.fetchAllWithGivenDepartmentDtoOrNoDepartment(Mockito.<DepartmentDto>any()))
                .thenReturn(new ArrayList<>());
        BreadcrumbService crumb = mock(BreadcrumbService.class);
        when(crumb.getBreadcrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                crumb);

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress("42 Main St");
        dto.setDean(new Teacher());
        dto.setFieldsOfStudy(new HashSet<>());
        dto.setId(1L);
        dto.setName("Name");
        dto.setTelNumber("42");

        BindException result = new BindException("Target", "Object Name");
        result.addError(new ObjectError("success", "success"));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertEquals("department/department-edit-form",
                departmentController.editDepartment(dto, result, redirectAttributes, request, new ConcurrentModel()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(teacherService).fetchAll();
        verify(fieldOfStudyService).fetchAllWithGivenDepartmentDtoOrNoDepartment(Mockito.<DepartmentDto>any());
        verify(crumb).getBreadcrumbs(Mockito.<String>any());
    }

    @Test
    void testDeleteDepartment() {
        DepartmentRepository repository = mock(DepartmentRepository.class);
        doNothing().when(repository).delete(Mockito.<Department>any());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new Department()));
        DepartmentService service = new DepartmentService(repository, new ModelMapper());

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());
        assertEquals(DepartmentController.REDIRECT_DASHBOARD_DEPARTMENTS,
                departmentController.deleteDepartment(1L, new RedirectAttributesModelMap()));
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(repository).delete(Mockito.<Department>any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteDepartment2() {
        DepartmentRepository repository = mock(DepartmentRepository.class);
        doNothing().when(repository).delete(Mockito.<Department>any());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        DepartmentService service = new DepartmentService(repository, new ModelMapper());

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());
        departmentController.deleteDepartment(1L, new RedirectAttributesModelMap());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteDepartment3() {

        DepartmentRepository repository = mock(DepartmentRepository.class);
        doNothing().when(repository).delete(Mockito.<Department>any());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new Department()));
        DepartmentService service = new DepartmentService(repository, null);

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());
        departmentController.deleteDepartment(1L, new RedirectAttributesModelMap());
    }

    @Test
    void testDeleteDepartment4() {
        DepartmentRepository repository = mock(DepartmentRepository.class);
        doNothing().when(repository).delete(Mockito.<Department>any());
        when(repository.findById(Mockito.<Long>any())).thenReturn(Optional.of(new Department()));

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        ModelMapper mapper = mock(ModelMapper.class);
        when(mapper.map(Mockito.<Object>any(), Mockito.<Class<DepartmentDto>>any())).thenReturn(departmentDto);
        DepartmentService service = new DepartmentService(repository, mapper);

        TeacherRepository repository2 = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository2, new ModelMapper());

        FieldOfStudyRepository repository3 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository3, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());
        assertEquals(DepartmentController.REDIRECT_DASHBOARD_DEPARTMENTS,
                departmentController.deleteDepartment(1L, new RedirectAttributesModelMap()));
        verify(repository, atLeast(1)).findById(Mockito.<Long>any());
        verify(repository).delete(Mockito.<Department>any());
        verify(mapper).map(Mockito.<Object>any(), Mockito.<Class<DepartmentDto>>any());
    }

    @Test
    void testDeleteDepartment5() {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setAddress("42 Main St");
        departmentDto.setDean(new Teacher());
        departmentDto.setFieldsOfStudy(new HashSet<>());
        departmentDto.setId(1L);
        departmentDto.setName("Name");
        departmentDto.setTelNumber("42");
        DepartmentService service = mock(DepartmentService.class);
        when(service.fetchById(Mockito.<Long>any())).thenReturn(departmentDto);
        doNothing().when(service).remove(Mockito.<Long>any());
        TeacherRepository repository = mock(TeacherRepository.class);
        TeacherService teacherService = new TeacherService(repository, new ModelMapper());

        FieldOfStudyRepository repository2 = mock(FieldOfStudyRepository.class);
        FieldOfStudyService fieldOfStudyService = new FieldOfStudyService(repository2, new ModelMapper());

        DepartmentController departmentController = new DepartmentController(service, teacherService, fieldOfStudyService,
                new BreadcrumbService());
        assertEquals(DepartmentController.REDIRECT_DASHBOARD_DEPARTMENTS,
                departmentController.deleteDepartment(1L, new RedirectAttributesModelMap()));
        verify(service).fetchById(Mockito.<Long>any());
        verify(service).remove(Mockito.<Long>any());
    }
}

