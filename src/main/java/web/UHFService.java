package web;


import web.UHF18.UHFReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Service
public class UHFService {

    private Map<Integer, UHFReader> uhfReaders;

    @Autowired
    public void UFHService()
    {
        uhfReaders = new HashMap<>();
    }

    public int createMainFrameInstance() {
        try {
            UHFReader reader = new UHFReader();
            final int identityHash = System.identityHashCode(reader);
            System.out.println("INFO: Created reader with id-"+identityHash);
            this.uhfReaders.put(identityHash, reader);
            return identityHash;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot create Instance");
        }
    }

    public boolean openTCP(int id, String Ipaddr,int Port) {
        if (!this.uhfReaders.containsKey(id)) {
            System.out.println("INFO: Id not found.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id not found");
        }
        try {
            final UHFReader reader = this.uhfReaders.get(id);
            final int responseCode = reader.OpenByTcp(Ipaddr, Port);
            System.out.println("INFO: open TCP Response code-"+responseCode);
            return responseCode == 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot Open Serial Port");
        }
    }

    public boolean closeTCP(int id) {
        if (!this.uhfReaders.containsKey(id)) {
            System.out.println("INFO: Id not found.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id not found");
        }
        try {
            final UHFReader reader = this.uhfReaders.get(id);
            final int responseCode = reader.CloseByTcp(reader.FrmHandle);
            System.out.println("INFO: close TCP Response code-"+responseCode);
            return responseCode == 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot Open Serial Port");
        }
    }
    public boolean startTCP(int id) {
        if (!this.uhfReaders.containsKey(id)) {
            System.out.println("INFO: Id not found.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id not found");
        }
        try {
            System.out.println("INFO: Communication Started.");
            final UHFReader reader = this.uhfReaders.get(id);
           // final String[] EPC = reader.Inventory();
            reader.timeQyery=true;
            reader.timeVoid();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot Open Serial Port");
        }
    }
    public boolean stopTCP(int id) {
        if (!this.uhfReaders.containsKey(id)) {
            System.out.println("INFO: Id not found.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id not found");
        }
        try {
            final UHFReader reader = this.uhfReaders.get(id);
            reader.timeQyery=false;
            System.out.println("INFO: Communication Stopped.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot Stop Serial Port");
        }
    }
}
