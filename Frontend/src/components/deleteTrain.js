import React, { Component } from "react";
import AdminNavigationBar from "./adminNavigationBar";
import axios from "axios";
import { Redirect, Link } from "react-router-dom";

export default class UpdateTrain extends Component {
  state = {
    trainid: "",
    trainName: "",
    startStation: "",
    endStation: "",
    timings: "",
    isTrainDeleted: false
  };

  handleTrainid = event => {
    const { value } = event.target;
    if (value != null) {
      this.setState({ trainid: value.toUpperCase() });
    }
  };


  handleTrainName = event => {
    const { value } = event.target;
    if (value != null) {
      this.setState({ trainName: value.toUpperCase() });
    }
  };

  handlestartStation = event => {
    const { value } = event.target;
    this.setState({ startStation: value.toUpperCase() });
  };

  handleendStation = event => {
    const { value } = event.target;
    this.setState({ endStation: value.toUpperCase() });
  };

  handletimings = event => {
    const { value } = event.target;
    this.setState({ timings: value.toUpperCase() });
  };



  handleSubmit = event => {
    event.preventDefault();

    const newTrain = {
      trainid: this.state.trainid,
      trainName: this.state.trainName,
      startStation: this.state.startStation,
      endStation: this.state.endStation,
      timings: this.state.timings,
    
    };

    axios
      .delete(
        "http://localhost:8890/trains/delete/"+this.state.trainid,
        newTrain
      )
      .then(response => response)
      .catch(error => error.message);

    window.alert("Train deleted successfully");
    this.setState({
        trainid: "",
        trainName: "",
        startStation: "",
        endStation: "",
        timings: "",
    
      isTrainDeleted: true
    });
  };
  render() {
    if (this.state.isTrainDeleted) {
      return <Redirect to="/trainlist" />;
    }
    console.log(this.props.adminId === "");
    if (this.props.adminId === "") {
      return <Redirect to="/adminSignIn" />;
    }

    return (
      <div>
        <AdminNavigationBar />
        <div className="d-flex justify-content-center">
          <div className="card bg-light mb-3">
            <div className="card-header">
              <h3 className="d-flex justify-content-center">Delete Train</h3>
            </div>
            <div className="card-body">
              <h5 className="card-title">
                <form onSubmit={this.handleSubmit}>
                  <div className="form-row">
                    <div className="col">
                      <label htmlFor="trainNumber">Train Id</label>
                      <input
                        type="name"
                        className="form-control"
                        id="trainid"
                        onChange={this.handleTrainid}
                        value={this.state.trainid}
                        required
                      />
                    </div>
                    
                  </div>
                  <br />
                
                  <br />
                  <div>
                    <button
                      type="submit"
                      value="createTicket"
                      className="btn btn-dark btn-lg btn-block"
                    >
                      Delete Train
                    </button>
                   
                   
                  </div>
                </form>
              </h5>
            </div>
          </div>
        </div>
      </div>
    );
  }
}