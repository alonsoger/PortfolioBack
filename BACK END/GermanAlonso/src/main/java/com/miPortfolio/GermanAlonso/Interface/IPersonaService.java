
package com.miPortfolio.GermanAlonso.Interface;

import com.miPortfolio.GermanAlonso.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(int id);
    
    public Persona findPersona(int id);
    
}
