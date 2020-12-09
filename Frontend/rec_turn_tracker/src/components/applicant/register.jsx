import React from "react";
<<<<<<< HEAD:Frontend/rec_turn_tracker/src/components/login/register.jsx
import loginImg from "../../login.svg";
import axios from 'axios';

=======
import loginImg from "../../signup.svg";
>>>>>>> 76c46d5e5a7f3b2bb9626fd9a401269987ff3db0:Frontend/rec_turn_tracker/src/components/applicant/register.jsx

export class Register extends React.Component {
  constructor(props) {
    super(props);
  }

  state = {
    email: "",
    password: "",
    confirmPassword: ""
  }

  BASE_URL = "http://localhost:8080/api/turntablexe/"



  onChangeHandler = (event) => {
    let nam = event.target.name;
    let value = event.target.value;
    this.setState({ [nam]: value })
  }


  register = () => {
    const { email, password, confirmPassword } = this.state
    if ((this.state.password === this.state.confirmPassword) && (this.state.password != "")) {
      axios.post(this.BASE_URL + "register", { email, password })
        .then(res => console.log(res))
        .catch(err => console.log(err))
    }
    else { console.log("Bad data") }
  }
  render() {
    const { email, password, confirmPassword } = this.state
    return (
<<<<<<< HEAD:Frontend/rec_turn_tracker/src/components/login/register.jsx
      <form>
        <div className="base-container" ref={this.props.containerRef}>
          <div className="header">Register</div>
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
              <div className="form-group">
                <label htmlFor="password">Password Confirmation</label>
                <input type="password" name="confirmPassword" placeholder="Confirm Password" onChange={this.onChangeHandler} value={confirmPassword} required />
              </div>
=======
      <div className="base-container" ref={this.props.containerRef}>
        <div className="header">Register</div>
        <div className="content">
          <div className="image">
            <img src={loginImg} />
          </div>
          <div className="form">
            <div className="form-group">
              <label htmlFor="email">Email</label>
              <input type="email" name="email" placeholder="Enter Email" required/>
            </div>
            <div className="form-group">
              <label htmlFor="email">Password</label>
              <input type="password" name="password" placeholder="Enter Password" required/>
            </div>
            <div className="form-group">
              <label htmlFor="password">Password Confirmation</label>
              <input type="password" name="confirmPassword" placeholder="Confirm Password" required/>
>>>>>>> 76c46d5e5a7f3b2bb9626fd9a401269987ff3db0:Frontend/rec_turn_tracker/src/components/applicant/register.jsx
            </div>
          </div>
          <div className="footer">
            <button type="submit" className="button" onClick={this.register}>
              Register
          </button>
          </div>
        </div>
      </form>

    );
  }
}
