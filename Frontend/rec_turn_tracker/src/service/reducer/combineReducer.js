import { combineReducers } from 'redux'
import { LoginReducer } from './loginReducer'
import { RegisterReducer } from './registerReducer'

export const AllReducer = combineReducers({ isLogin: LoginReducer, Register: RegisterReducer });