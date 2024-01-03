package com.example.demo.util;

import com.example.demo.dto.AddressDTO;
import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.DeviceDTO;
import com.example.demo.dto.MeasuringDTO;
import com.example.demo.model.Address;
import com.example.demo.model.Client;
import com.example.demo.model.Device;
import com.example.demo.model.Measuring;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static AddressDTO addressToAddressDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId(address.getId());
        addressDTO.setName(address.getName());

        return addressDTO;
    }

    public static Address addressDTOToAddress(AddressDTO addressDTO) {
        Address address = new Address();

        address.setId(addressDTO.getId());
        address.setName(addressDTO.getName());

        return address;
    }

    public static ClientDTO clientToClientDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(client.getId());
        clientDTO.setAddress(client.getAddress());

        return clientDTO;
    }

    public static Client clientDTOToClient(ClientDTO clientDTO) {
        Client client = new Client();

        client.setId(clientDTO.getId());
        client.setAddress(clientDTO.getAddress());

        return client;
    }

    public static DeviceDTO deviceToDeviceDTO(Device device) {
        DeviceDTO deviceDTO = new DeviceDTO();

        deviceDTO.setId(device.getId());

        return deviceDTO;
    }

    public static Device deviceDTOToDevice(DeviceDTO deviceDTO) {
        Device device = new Device();

        device.setId(deviceDTO.getId());

        return device;
    }

    public static MeasuringDTO measuringToMeasuringDTO(Measuring measuring) {
        MeasuringDTO measuringDTO = new MeasuringDTO();

        measuringDTO.setId(measuring.getId());
        measuringDTO.setClient(measuring.getClient());
        measuringDTO.setDevice(measuring.getDevice());
        measuringDTO.setData(measuring.getData());
        measuringDTO.setDate(measuring.getDate());

        return measuringDTO;

    }

    public static List<MeasuringDTO> measuringsToMeasuringDTOs(List<Measuring> measurings) {
        List<MeasuringDTO> measuringDTOs = new ArrayList<>();
        for (Measuring elem : measurings) {
            measuringDTOs.add(measuringToMeasuringDTO(elem));
        }

        return measuringDTOs;
    }
}
