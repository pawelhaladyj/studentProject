package pl.haladyj.libraryStudentProject.reader.phoneNumber;

import pl.haladyj.libraryStudentProject.reader.ReaderDto;

import java.util.Arrays;

public class PhoneNumberValidator {

    private ReaderDto readerDTO;
    private String phoneNumber = readerDTO.getPhoneNumber();
    private String defaultPrefix = "81";

    private PhoneTypes phoneType;

    public String convertToDigit(){
        return phoneNumber.replaceAll("[^0-9]","");
    }

    public int getPhoneNumberLength(){
        String phoneNumber = convertToDigit();
        return phoneNumber.length();
    }


    private String digitPhoneNumber = convertToDigit();
    private int phoneNumberLength = getPhoneNumberLength();

    public PhoneTypes asignType(){
        if(phoneNumberLength<7){
            phoneType = PhoneTypes.wrong;
        } else if(phoneNumberLength == 7){
            byte[] byteNumber = digitPhoneNumber.getBytes();
            if(byteNumber[0]==0){
                phoneType = PhoneTypes.wrong;
            } else {
                digitPhoneNumber = defaultPrefix + digitPhoneNumber;
                phoneType = PhoneTypes.landline;
            }
        } else if(phoneNumberLength == 8){
            phoneType = PhoneTypes.wrong;
        } else if(phoneNumberLength == 9){

            Integer prefix = Integer.parseInt(digitPhoneNumber.substring(0,1));
            int[] prefixArray = {12,13,14,15,16,17,18,22,23,24,25,29,32,33,34,38,41,42,43,44,46,48,52,54,55,56,58,59,61,62,63,65,67,68,69,71,74,75,76,77,79,81,82,83,84,85,86,87,89,91,94,95};

            if(digitPhoneNumber.getBytes()[0]==0){
                phoneType = PhoneTypes.wrong;
            }else if(Arrays.asList(prefixArray).contains(prefix)){
                phoneType = PhoneTypes.landline;
            }else{
                phoneType = PhoneTypes.mobile;
            }
        } else if(phoneNumberLength == 10){

            Integer prefix = Integer.parseInt(digitPhoneNumber.substring(1,2));
            int[] prefixArray = {12,13,14,15,16,17,18,22,23,24,25,29,32,33,34,38,41,42,43,44,46,48,52,54,55,56,58,59,61,62,63,65,67,68,69,71,74,75,76,77,79,81,82,83,84,85,86,87,89,91,94,95};

            if(digitPhoneNumber.getBytes()[1]==0){
                phoneType = PhoneTypes.wrong;
            }else if(Arrays.asList(prefixArray).contains(prefix)){
                phoneType = PhoneTypes.landline;
            }else{
                phoneType = PhoneTypes.mobile;
            }
        } else if(phoneNumberLength>10){
            phoneType = PhoneTypes.wrong;
        }

        return phoneType;
    }



}
