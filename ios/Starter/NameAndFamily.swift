//
//  NameAndFamily.swift
//  server
//
//  Created by reza on 12/28/1398 AP.
//  Copyright © 1398 reza. All rights reserved.
//

import Foundation

struct NameAndFamily {
    
    private(set) public var name : String!
    private(set) public var family : String!

    init(name: String!, family: String!) {
        self.name = name
        self.family = family
    }

}
