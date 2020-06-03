import React from 'react';
import Link from './Link.react';
import SortActions from '../actions/SortActions';




class Actions extends React.Component {
    constructor(props) {
        super(props);

        this.setState = this.setState.bind(this);
        this.onLinkClick = this.onLinkClick.bind(this);
    }

    onLinkClick(action) {
        SortActions.executeAction(action);
    }

    render() {
        return (
            <div>
                <ul className="list-inline">
                    <li className="list-inline-item"><Link label='Create Data' path='create' handleOnClick={this.onLinkClick.bind(this)}/></li>
                    <li className="list-inline-item"><Link label='Delete Data' path='delete' handleOnClick={this.onLinkClick.bind(this)} /></li>
                    <li className="list-inline-item"><Link label='Sort Data' path='sorted' handleOnClick={this.onLinkClick.bind(this)}/></li>
                    <li className="list-inline-item"><Link label='Unsort Data' path='unsorted' handleOnClick={this.onLinkClick.bind(this)}/></li>
                </ul>
            </div>
        );
    }
}

export default Actions;