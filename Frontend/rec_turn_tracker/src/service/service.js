import axios from 'axios'


const BASE_URL = "http://localhost:8080/api/turntablexe/"

const register = (email, password, password1) => {
    if (password === password1 && (password !== "" && password1 !== "")) {
        axios.post(BASE_URL + "register", { email, password })
            .then(res => res)
            .catch(err => err)
    } else {
        console.log("did not match")
    }
}

export default { register };