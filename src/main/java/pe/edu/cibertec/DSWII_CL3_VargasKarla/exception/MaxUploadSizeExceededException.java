package pe.edu.cibertec.DSWII_CL3_VargasKarla.exception;

public class MaxUploadSizeExceededException extends RuntimeException {

    public MaxUploadSizeExceededException(String message){
        super(message);
    }
}
