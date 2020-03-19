//
//  ViewController.swift
//  server
//
//  Created by reza on 12/28/1398 AP.
//  Copyright © 1398 reza. All rights reserved.
//

import UIKit
import Alamofire
import SwiftyJSON

class MainVC: UIViewController, UITableViewDataSource, UITableViewDelegate {

    var nameArray : [NameAndFamily] = []

    @IBOutlet weak var tableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        getJson()
    }



    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return nameArray.count
       }


    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if let cell = tableView.dequeueReusableCell(withIdentifier: "cell") as? TableViewCell {
            let array = nameArray[indexPath.row]
            cell.updateView(nameAndFamily: array)
            return cell
        }
        else {
            return TableViewCell()
        }
    }


        func getJson(){
            Alamofire.request("Http://192.168.1.154:8082/student/getAll", method: .get).responseJSON { response in
                if response.result.isSuccess {
                    
                    let result = JSON(response.result.value!)
                    print(result)
                        for i in result{
                                let name = i.1["studentName"].stringValue
                                let family = i.1["studentFamily"].stringValue
                            self.nameArray.append(NameAndFamily(name: name, family: family))
                    }
                    DispatchQueue.main.async {
                        self.tableView.reloadData()
                    }
                }else{
                    print("Error \(String(describing: response.result.error))")
                }
            }
        }
}

