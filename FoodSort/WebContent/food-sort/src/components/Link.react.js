import React, { Component } from 'react';


class Link extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id : '',
            label : ''
        }
        this.handleOnClick = this.handleOnClick.bind(this);
    }

    handleOnClick() {
        this.props.handleOnClick(this.props.path)
    }

    render() {
        return (
            <div>
                <a href={'#'} onClick={this.handleOnClick}><h3>{this.props.label}</h3></a>
            </div>
    );
    }
}
export default Link