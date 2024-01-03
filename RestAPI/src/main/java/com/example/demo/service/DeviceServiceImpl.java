package com.example.demo.service;

import com.example.demo.dto.DeviceDTO;
import com.example.demo.model.Client;
import com.example.demo.model.Device;
import com.example.demo.model.Measuring;
import com.example.demo.repository.DeviceRepository;
import com.example.demo.repository.MeasuringRepository;
import com.example.demo.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private DeviceRepository deviceRepository;

    @Override
    public void addNew(DeviceDTO deviceDTO) {
        Device device = Mapper.deviceDTOToDevice(deviceDTO);
        deviceRepository.save(device);
    }

    @Override
    public Device findById(Long id) throws Exception {
        Optional<Device> optionalDevice = deviceRepository.findById(id);

        if (optionalDevice.isEmpty()) {
            throw new Exception("Device with id " + id + " does not exist");
        }

        return optionalDevice.get();
    }


}