package service;

import com.example.demo.util.Mapper;
import dto.ClientDTO;
import lombok.Data;
import model.Address;
import model.Client;
import org.springframework.stereotype.Service;
import repository.AddressRepository;
import repository.ClientRepository;

@Service
@Data
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private AddressRepository addressRepository;

    @Override
    public void addNew(ClientDTO clientDTO) throws Exception {

        Client client = Mapper.clientDTOToClient(clientDTO);
        if (isInvalidAddress(client.getAddress())){
            throw new Exception("Address is already used!");
        }
        //client.getDevice().setData(generateData());
        clientRepository.save(client);
    }


    private boolean isInvalidAddress(Address address){
        return !addressRepository.existsAddressByName(address.getName());
    }

    private String generateData(){
        return Math.random() + " W";
    }


}
