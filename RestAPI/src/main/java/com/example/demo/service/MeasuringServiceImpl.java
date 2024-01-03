package com.example.demo.service;

import com.example.demo.dto.CreateMeasuringRequest;
import com.example.demo.dto.MeasuringDTO;
import com.example.demo.model.Client;
import com.example.demo.model.Device;
import com.example.demo.model.Measuring;
import com.example.demo.repository.MeasuringRepository;
import com.example.demo.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class MeasuringServiceImpl implements MeasuringService {

    private MeasuringRepository measuringRepository;
    private DeviceService deviceService;
    private ClientService clientService;

    @Override
    public void addNew(CreateMeasuringRequest createMeasuringRequest) throws Exception {
        Measuring measuring = new Measuring();
        Device device = deviceService.findById(createMeasuringRequest.getDeviceId());
        Client client = clientService.findById(createMeasuringRequest.getClientId());

        List<Measuring> measurings = measuringRepository.findByClientId(createMeasuringRequest.getClientId());
        if (measurings.isEmpty()){
            measuring.setClient(client);
            measuring.setDevice(device);
            measuring.setDate(LocalDate.now());
            measuring.setData(generateData());
        }
        else{
            for (Measuring m:measurings) {
                if(m.getDevice().getId()!= createMeasuringRequest.getDeviceId())
                    throw new Exception("Client already has a device!");
            }
        }

        measuringRepository.save(measuring);
    }

    @Override
    public List<MeasuringDTO> getAll() {
        List<Measuring> measurings= measuringRepository.findAll();
        return Mapper.measuringsToMeasuringDTOs(measurings);
    }


    private String generateData() {
        double randNum = Math.random() * 200 + 100;
        return Math.round(randNum * 100) / 100 + "W";
    }

}
