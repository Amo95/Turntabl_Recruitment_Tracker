import { combineReducers } from 'redux'
import { LoginReducer } from './loginReducer'
import { RegisterReducer } from './registerReducer'

export const AllReducer = combineReducers({ Login: LoginReducer, Register: RegisterReducer });