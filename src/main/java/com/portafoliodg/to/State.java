package com.portafoliodg.to;

public class State {
    private boolean isOK;
    private String descripcion;
    
        public State(boolean isOK, String descripcion){
            super();
            this.isOK = isOK;
            this.descripcion = descripcion;
        }
        
        public boolean isOK(){
            return isOK;
        }
        
        public void setOK(boolean isOK){
            this.isOK = isOK;
        }
        
        public String getDescripcion(){
            return descripcion;
        }
        
        public void setDescripcion(String descripcion){
            this.descripcion = descripcion;
        }
}
