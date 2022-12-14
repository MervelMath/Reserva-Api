package com.ReservasApi.springReservas.DTOmodule;

import java.io.Serializable;

import com.ReservasApi.springReservas.DominioModule.Reserva;

public class ReservaDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String data;
    private String horaInicio;
    private String horaTermino;
    public ReservaDTO(Reserva obj){
        this.id = obj.getId();
        this.data = obj.getData();
        this.horaInicio = obj.getHoraInicio();
        this.horaTermino = obj.getHoraTermino();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
            ReservaDTO other = (ReservaDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    //region gets e sets    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }

    //endregion
}
