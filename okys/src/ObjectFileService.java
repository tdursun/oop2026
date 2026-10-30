
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectFileService {

public static void saveItems(String filename, List<Kitap> items) throws IOException {
     ObjectOutputStream obj = null;
      
     try {
        obj = new ObjectOutputStream(new FileOutputStream(filename));
 
        for (int x=0; x<items.size();x++){
            obj.writeObject(items.get(x));
        }
        // obj.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally { if (obj != null) obj.close(); }
   }
	
public static List<Kitap> loadItems(String filename) throws IOException {
  List<Kitap> load = new ArrayList<>();
  try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(filename))) {
    while (true) {
      try {
        Object item = obj.readObject();
        if (!(item instanceof Kitap kitap)) {
          throw new IOException("Object file contains an item that is not a Kitap.");
        }
        load.add(kitap);
      } catch (EOFException e) {
        break;
      } catch (ClassNotFoundException e) {
        throw new IOException("Could not load a serialized item.", e);
      }
    }
  }
  return load;
   }
    
}

