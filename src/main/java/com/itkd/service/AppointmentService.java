package com.itkd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itkd.entity.Appointment;

public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);
}