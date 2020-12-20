import { LOGIN, LOGOUT, REGISTER_SUCCESS, REGISTER_FAIL } from "./actionsConstant";
import axios from 'axios'
import { message } from 'antd'

const BASE_URL = "http://localhost:8080/api/turntablexe/";

const email_re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;



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
        axios.post(BASE_URL + "login", { email, password })
            .then(res => {
                const { id, email, password } = res.data
                if ((id !== 0 || id !== null) && (email !== null)) {
                    // localStorage.setItem("id", id)
                    // localStorage.setItem("email", email)
                    // localStorage.setItem("password", password)
                    dispatch(login(res.data))
                }
                else {
                    message.error("Invalid email or password")
                }
            })
            .catch(err => console.log(err));
    } else {
        console.log("Bad data")
    }
}


export const register = (email, password) => dispatch => {
    axios.post(BASE_URL + "register", { email: email, password: password })
        .then(res => {
            if (res.data.email === "User already exist") {

                message.error("User Already Exist")
                dispatch(register_fail())
            }
            else if (res.data !== "") {
                const { id, email, password } = res.data
                localStorage.setItem("id", id)
                message.success("Register Successful Checkout to Login")
                dispatch(register_succes())
            }
        })
        .catch(err => console.log(err));
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