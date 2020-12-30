import { LOGIN, LOGIN_INIT, LOGIN_END, LOGOUT, REGISTER_SUCCESS, REGISTER_FAIL, REGISTER_INIT, REGISTER_END } from "./actionsConstant";
import axios from 'axios'
import { message } from 'antd'

const BASE_URL = "http://localhost:8080/api/turntablexe/";

const email_re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;



export const logininit = () => ({
    type: LOGIN_INIT
});


export const loginend = () => ({
    type: LOGIN_END
});


export const login = (payload) => {
    return {
        type: LOGIN,
        payload
    }
}


export const logout = () => {
    return {
        type: LOGOUT,
    }
}



export const registerinit = () => ({
    type: REGISTER_INIT
});


export const registerend = () => ({
    type: REGISTER_END
});

export const register_succes = () => {
    return {
        type: REGISTER_SUCCESS,
    }
}

export const register_fail = () => {
    return {
        type: REGISTER_FAIL,
    }
}

export const apply = () => {
    return {
        type: "APPLY",
    }
}



export const loginUser = (email, password) => (dispatch) => {
    if ((email.length > 0 && password.length >= 6) && email.match(email_re)) {
        dispatch(logininit())
        axios.post(BASE_URL + "login", { email, password })
            .then(res => {
                const { id, email } = res.data

                if (res.data === "Wrong username/password") {
                    dispatch(loginend())
                    message.info("Wrong username/password")
                }
                else if (res.data === "Activate account from your email") {
                    dispatch(loginend())
                    message.info("Activate account from your email")
                }
                else {
                    localStorage.setItem("id", res.data.id)
                    localStorage.setItem("email", res.data.email)
                    dispatch(login(res.data))
                }
            })
            .catch(err => {
                dispatch(loginend())
            });
    } else {
        message.warn("Invalid User or Password")
    }
}


export const register = (email, password, confirmPassword) => dispatch => {
    dispatch(registerinit())
    axios.post(BASE_URL + "register", { email: email, password: password, confirmPassword: confirmPassword })
        .then(res => {
            if (res.data === "User already exist") {
                dispatch(registerend())
                message.error("User Already Exist")
                dispatch(register_fail())
            }
            else if (res.data !== "") {
                const { id, email, password } = res.data
                dispatch(registerend())
                message.success("Register Successful Check email to activate account")
                dispatch(register_succes())
            }
        })
        .catch(err => err);
}



export const submitApplicantData = (id, first_name, middle_name, last_name, nickname, dob, gender, university, year_of_graduation, address1, address2, city, region, zip_code, ssnit_number, nss_number, phone_number, whatsApp_number, referral) => {

    axios.put(BASE_URL + `applicants/${id}`, {
        first_name: first_name,
        middle_name: middle_name,
        last_name: last_name,
        nickname: nickname,
        dob: dob,
        gender: gender,
        university: university,
        year_of_graduation: year_of_graduation,
        address1: address1,
        address2: address2,
        city: city,
        region: region,
        zip_code: zip_code,
        ssnit_number: ssnit_number,
        nss_number: nss_number,
        phone_number: phone_number,
        whatsApp_number: whatsApp_number,
        referral: referral
    })
        .then(res => res)
        .catch(err => console.log(err));
}