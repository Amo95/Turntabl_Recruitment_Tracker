import React from "react";
import loginImg from "../../login.svg";
import { connect } from 'react-redux'
// import { loginUser } from '../../service/service'

import { loginInit, loginUser } from '../../service/actions/actions'
import { Redirect } from "react-router-dom";
class Login extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      email: "",
      password: ""
    }
  }

  onChangeHandler = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  }

  onSubmitHandler = (e) => {
    e.preventDefault()
    const { email, password } = this.state
    this.props.dispatch(loginUser(email, password))
  }
  render() {
    const { email, password } = this.state
    if (this.props.login_stat) {
      localStorage.setItem("isLogedIn", this.props.login_stat)
      return <Redirect to="/applyv2" />
    }
    else if (localStorage.getItem("isLogedIn") !== null) {
      return <Redirect to="/applyv2" />
    }
    else {
      return (
        <form onSubmit={this.onSubmitHandler}>
          <div className="base-container" ref={this.props.containerRef}>
            <div className="header">Login</div>
            <div className="content">
              <div className="image">
                <img src={loginImg} />
              </div>
              <div className="form">
                <div className="form-group">
                  <label htmlFor="email">Email</label>
                  <input type="email" name="email" placeholder="Enter Email" onChange={this.onChangeHandler} value={email} required />
                </div>
                <div className="form-group">
                  <label htmlFor="email">Password</label>
                  <input type="password" name="password" placeholder="Enter Password" onChange={this.onChangeHandler} value={password} required />
                </div>
              </div>
            </div>
            <div className="footer">
              <button type="submit" className="button">
                Login
            </button>
            </div>
            <a href="http://" target="_blank" rel="noopener noreferrer"> <b>Forgot Password?</b> </a>
          </div>
        </form>
      );
    }
  }
}
const mapStateToProps = state => ({
  uId: state.isLogin.id,
  uEmail: state.isLogin.email,
  login_stat: state.isLogin.login_status
});

export default connect(mapStateToProps)(Login)
