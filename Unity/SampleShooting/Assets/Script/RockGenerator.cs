using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RockGenerator : MonoBehaviour {

    public GameObject rockPrefab;

	// Use this for initialization
	void Start () {
        //InvokeRepeating関数：第一引数の関数を第二引数の秒数ごとに実行する
        //引数１：呼び出す関数
        //引数２：呼び出す間隔
        InvokeRepeating("GenRock", 1, 1);
	}
	
    void GenRock()
    {
        Instantiate(rockPrefab, new Vector3(-2.5f + 5 * Random.value, 5, 0), Quaternion.identity);
    }
}
