package com.example.demo.util;

import dto.AddressDTO;
import dto.ClientDTO;
import dto.DeviceDTO;
import model.Address;
import model.Client;
import model.Device;

public class Mapper {
    public static AddressDTO addressToAddressDTO(Address address){
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId(address.getId());
        addressDTO.setName(address.getName());

        return addressDTO;
    }

    public static Address addressDTOToAddress(AddressDTO addressDTO){
        Address address = new Address();

        address.setId(addressDTO.getId());
        address.setName(addressDTO.getName());

        return address;
    }

    public static ClientDTO clientToClientDTO (Client client){
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(client.getId());
        clientDTO.setDevice(client.getDevice());
        clientDTO.setAddress(client.getAddress());

        return clientDTO;
    }

    public static Client clientDTOToClient (ClientDTO clientDTO){
        Client client = new Client();

        client.setId(clientDTO.getId());
        client.setAddress(clientDTO.getAddress());
        client.setDevice(clientDTO.getDevice());

        return client;
    }

    public static DeviceDTO deviceToDeviceDTO (Device device){
        DeviceDTO deviceDTO = new DeviceDTO();

        deviceDTO.setId(device.getId());
        deviceDTO.setData(device.getData());

        return deviceDTO;
    }

    public static Device deviceDTOToDevice (DeviceDTO deviceDTO){
        Device device = new Device();

        device.setId(deviceDTO.getId());
        device.setData(deviceDTO.getData());

        return device;
    }
}
