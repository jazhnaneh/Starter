//
//  TableViewCell.swift
//  server
//
//  Created by reza on 12/28/1398 AP.
//  Copyright © 1398 reza. All rights reserved.
//

import UIKit

class TableViewCell: UITableViewCell {

    @IBOutlet weak var family: UILabel!
    @IBOutlet weak var name: UILabel!
    
    
    func updateView(nameAndFamily: NameAndFamily){
        name.text = nameAndFamily.name
        family.text = nameAndFamily.family
    }
    

}
