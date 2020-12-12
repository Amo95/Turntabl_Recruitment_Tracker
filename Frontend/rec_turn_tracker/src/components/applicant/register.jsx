import React from "react";
import loginImg from "../../signup.svg";
import { register } from '../../service/service';

export class Register extends React.Component {
  constructor(props) {
    super(props);
  }

  state = {
    email: "",
    password: "",
    confirmPassword: ""
  }

  onchangeHandler = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  }

  render() {
    const { email, password, confirmPassword } = this.state

    return (
      <div className="base-container" ref={this.props.containerRef}>
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
          <button type="submit" className="button" onClick={() => register(email, password, confirmPassword)}>
            Register
          </button>
        </div>
      </div>
    );
  }
}
