package com.example.demo.controller;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.CreateMeasuringRequest;
import com.example.demo.dto.DeviceDTO;
import com.example.demo.dto.MeasuringDTO;
import com.example.demo.service.ClientService;
import com.example.demo.service.DeviceService;
import com.example.demo.service.MeasuringService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/app")
public class AppController {

    private DeviceService deviceService;
    private ClientService clientService;
    private MeasuringService measuringService;

    @PostMapping("/device")
    public ResponseEntity<Void> addDevice(@RequestBody DeviceDTO deviceDTO) throws Exception {
        deviceService.addNew(deviceDTO);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/measuring")
    public ResponseEntity<Void> addMeasuring(@RequestBody CreateMeasuringRequest createMeasuringRequest) throws Exception {
        measuringService.addNew(createMeasuringRequest);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/client")
    public ResponseEntity<Void> addClient(@RequestBody ClientDTO clientDTO) throws Exception {
        clientService.addNew(clientDTO);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/measuring")
    public ResponseEntity<List<MeasuringDTO>> getAll(){
        return ResponseEntity.ok(measuringService.getAll());
    }

}
