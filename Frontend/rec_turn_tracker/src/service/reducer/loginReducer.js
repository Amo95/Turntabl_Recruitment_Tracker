import { LOGIN, LOGOUT } from "../actions/actionsConstant"



const initialState = {
    login_status: false,
    id: localStorage.getItem("id"),
    email: localStorage.getItem("email")
    
}

export const LoginReducer = (state = initialState, action) => {
    switch (action.type) {
        case LOGIN:
            return { ...state, login_status: true }
        case LOGOUT:
            return { ...state, login_status: false }
        default:
            return state
    }


}