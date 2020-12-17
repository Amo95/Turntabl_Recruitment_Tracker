import { LOGIN, LOGOUT, REGISTER_SUCCESS, REGISTER_FAIL } from "./actionsConstant";
import axios from 'axios'

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






export const loginUser = (email, password) => (dispatch) => {
    if ((email.length > 0 && password.length >= 6) && email.match(email_re)) {
        axios.post(BASE_URL + "login", { email, password })
            .then(res => {
                const { id, email, password } = res.data
                if ((id !== 0 || id !== null) && (email !== null)) {
                    localStorage.setItem("id", id)
                    localStorage.setItem("email", email)
                    localStorage.setItem("password", password)
                    dispatch(login(res.data))
                }
                else {
                    console.log("Not successfull")
                }
            })
            .catch(err => console.log(err));
    } else {
        console.log("Bad data")
    }
}


export const register = (email, password, confirm_password) => dispatch => {
    if (password.length >= 6 && password === confirm_password && (email !== null || email !== "") && email.match(email_re)) {
        axios.post(BASE_URL + "register", { email: email, password: password })
            .then(res => {
                if (res.data === "User already exist") {
                    dispatch(register_fail())
                } else {
                    dispatch(register_succes())
                }
            })
            .catch(err => console.log(err));
    } else {
        console.log("Bad")
    }
}
