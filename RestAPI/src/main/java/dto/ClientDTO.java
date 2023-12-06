package dto;

import lombok.Data;
import model.Address;
import model.Device;

@Data
public class ClientDTO {
    private Long id;

    private Address address;

    private Device device;
}
