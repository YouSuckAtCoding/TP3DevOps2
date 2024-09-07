package infnet.edu.tp3devops2.Domain.Primtives;

import org.springframework.data.annotation.Id;

public abstract class EntityRoot {
    
    @Id
    public long id;

    protected EntityRoot(long id) {
        this.id = id;
    }

    public boolean Equals(EntityRoot obj) {
        if (obj != null) {
            if (obj.getClass() != this.getClass()) {
                return false;
            }
            return obj.id == this.id;
        }

        return true;
    }

}
