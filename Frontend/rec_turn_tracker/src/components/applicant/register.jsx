import React from "react";
import loginImg from "../../signup.svg";
import { register } from '../../service/actions/actions';
import { connect } from 'react-redux'
import { message } from 'antd';

class Register extends React.Component {
  email_re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

  constructor(props) {
    super(props);
  }

  state = {
    email: "",
    password: "",
    confirmPassword: "",
    loader: false
  }

  onchangeHandler = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  }

  submitHandler = (event) => {
    const { email, password, confirmPassword } = this.state
    if (password.length >= 6 && password === confirmPassword && (email !== null || email !== "") && email.match(this.email_re)) {
      this.props.dispatch(register(email, password, confirmPassword))
    } else {
      message.warn("Fields must be entered or password mismatch")
    }


  }

  render() {
    const { email, password, confirmPassword } = this.state

    return (
      <div className="base-container" ref={this.props.containerRef}>
        {this.state.loader ? <div> loading..... </div> : <></>}
        <div className="header">Register</div>
        <div className="content">
          <div className="image">
            <img src={loginImg} />
          </div>
          <div className="form">
            <div className="form-group">
              <label htmlFor="email">Email</label>
              <input type="email" name="email" placeholder="Enter Email" value={email} onChange={this.onchangeHandler} required />
            </div>
            <div className="form-group">
              <label htmlFor="email">Password</label>
              <input type="password" name="password" placeholder="Enter Password" value={password} onChange={this.onchangeHandler} required />
            </div>
            <div className="form-group">
              <label htmlFor="password">Password Confirmation</label>
              <input type="password" name="confirmPassword" placeholder="Confirm Password" value={confirmPassword} onChange={this.onchangeHandler} required />
            </div>
          </div>
        </div>
        <div className="footer">
          <button type="submit" className="button" onClick={this.submitHandler}>
            Register
          </button>
        </div>

      </div>
    );
  }
}

const mapStateToProps = state => ({
  status: state.Register.status,
  message: state.Register.message
});

export default connect(mapStateToProps)(Register)