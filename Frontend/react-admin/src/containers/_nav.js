import React from 'react'
import CIcon from '@coreui/icons-react'

export default [
  {
    _tag: 'CSidebarNavItem',
    name: 'Dashboard',
    to: '/dashboard',
    icon: <CIcon name="cil-speedometer" customClasses="c-sidebar-nav-icon" />,
  },
  {
    _tag: 'CSidebarNavItem',
    name: 'Recruitment Tracker',
    to: '/base/breadcrumbs',
    icon: 'cil-puzzle',
    // _children: [
    //   {
    //     _tag: 'CSidebarNavItem',
    //     name: 'Recruitment Tracking Sheet',
    //     to: '/base/breadcrumbs',
    //   },
    //   {
    //     _tag: 'CSidebarNavItem',
    //     name: 'Interviews',
    //     to: '/base/cards',
    //   },
    //   {
    //     _tag: 'CSidebarNavItem',
    //     name: 'Candidates',
    //     to: '/base/carousels',
    //   },
    // ]
  }
]

