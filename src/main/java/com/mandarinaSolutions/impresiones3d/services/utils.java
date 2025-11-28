package com.mandarinaSolutions.impresiones3d.services;


import com.mandarinaSolutions.impresiones3d.exceptions.ArticuloEmptyCollectionException;
import com.mandarinaSolutions.impresiones3d.exceptions.ArticuloIllegalNullException;

class ArticuloUtils {
	
	public void checkListNotEmpty(int size) throws Exception{
		if(size == 0) {
			throw new ArticuloEmptyCollectionException();
		}
	};
	
	public void checkDoubleNotNull(Double number) throws Exception{
		if(number == null) {
			throw new ArticuloIllegalNullException();
		}
	};
	
	public void checkStringNotNull(String string) throws Exception{
		if(string == null) {
			throw new ArticuloIllegalNullException();
		}
	};
	
}


class utils2 {

}