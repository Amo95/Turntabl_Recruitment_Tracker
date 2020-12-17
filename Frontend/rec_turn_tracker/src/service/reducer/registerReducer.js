import { REGISTER_SUCCESS, REGISTER_FAIL } from "../actions/actionsConstant"



const initialState = {
    status: false,
    message: ""
}

export const RegisterReducer = (state = initialState, action) => {
    switch (action.type) {
        case REGISTER_SUCCESS:
            return { ...state, status: true, message: "Register Successful" }
        case REGISTER_FAIL:
            return { ...state, status: false, message: "User Allready Exist" }
        default:
            return state
    }


}