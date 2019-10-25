
package com.interland.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1-SNAPSHOT
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UserService", targetNamespace = "http://webservice.interland.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserService {


    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    public boolean addUser(
        @WebParam(name = "arg0", partName = "arg0")
        User arg0);

    /**
     * 
     * @return
     *     returns com.interland.webservice.UserArray
     */
    @WebMethod
    @WebResult(partName = "return")
    public UserArray getAllUsers();

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    public boolean deleteUser(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.interland.webservice.User
     */
    @WebMethod
    @WebResult(partName = "return")
    public User getUser(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

}
