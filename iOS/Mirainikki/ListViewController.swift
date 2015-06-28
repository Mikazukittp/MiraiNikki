//
//  ListViewController.swift
//  Mirainikki
//
//  Created by 石部達也 on 2015/06/28.
//  Copyright (c) 2015年 石部達也. All rights reserved.
//

import UIKit

class ListViewController: UIViewController {

    @IBOutlet weak var tableView: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()

        self.title = "未来日記"
        
        //Naviagationbar潜り込み防止
        self.edgesForExtendedLayout = UIRectEdge.None

        
        self.tableView.registerClass(UITableViewCell.self, forCellReuseIdentifier: "MyCell")
    }
    
    
    /*
    Cellが選択された際に呼び出されるデリゲートメソッド.
    */
    func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
//        println("Num: \(indexPath.row)")
//        println("Value: \(myItems[indexPath.row])")
    }
    
    /*
    Cellの総数を返すデータソースメソッド.
    (実装必須)
    */
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 10
    }
    
    /*
    Cellに値を設定するデータソースメソッド.
    (実装必須)
    */
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        
        // 再利用するCellを取得する.
        let cell: UITableViewCell = UITableViewCell(style: UITableViewCellStyle.Subtitle, reuseIdentifier: "MyCell")
        
        // Cellに値を設定する.
        cell.textLabel!.text = "aa"
//        "\(myItems[indexPath.row])"
        
        return cell
    }


    @IBAction func newButtonTapped(sender: AnyObject) {
        
        var pc = NewFeatureViewController(nibName: "NewFeatureViewController", bundle: nil)
        
        self.navigationController?.pushViewController(pc, animated: true)        
    }
}
