package algorithms.kmeans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class kmeans {
	private int K;
	private int dataNum;
	private int dimNum;
	private ArrayList<double[]> tuples;
	private ArrayList<ArrayList<double[]>> cluster;
	private ArrayList<double[]> means;

	public kmeans(int K, int dataNum, int dimNum, ArrayList<double[]> tuples) {
		this.K = K;
		this.dataNum = dataNum;
		this.dimNum = dimNum;
		this.tuples = tuples;
		cluster = new ArrayList<ArrayList<double[]>>();
		for (int i = 0; i < K; ++i) {
			cluster.add(new ArrayList<double[]>());
		}
		means = new ArrayList<double[]>();

	}

	// 获取 tupleA 和 tupleB的距离 , 下标0存放记录编号，下标1到dimNum存放实际元素
	private double getDis(double tupleA[], double tupleB[]) {
		double dis = 0;
		for (int k = 1; k <= dimNum; ++k) {
			dis += (tupleA[k] - tupleB[k]) * (tupleA[k] - tupleB[k]);
		}
		return Math.sqrt(dis);
	}

	// 获取t应该被分配到的簇的编号
	private int clusterOfTuple(double t[]) {
		int index = 0;
		double meanDis = getDis(means.get(0), t);
		double dis = 0;
		for (int i = 1; i < K; ++i) {
			dis = getDis(means.get(i), t);
			if (dis < meanDis) {
				meanDis = dis;
				index = i;
			}
		}
		return index;
	}

	// 重新求得每个簇的质心
	private void updateMeans() {
		means.clear();
		for (int i = 0; i < K; ++i) {
			double[] t = new double[dimNum + 1];
			t[0] = -1; // means点的编号统一为-1
			for (int j = 0; j < cluster.get(i).size(); ++j) {
				for (int l = 1; l < dimNum + 1; ++l) {
					t[l] += cluster.get(i).get(j)[l]; // 每个维度累加求和
				}
			}
			for (int l = 1; l < dimNum + 1; ++l) {
				t[l] = t[l] / cluster.get(i).size(); // 除以每个簇的节点数，求得平均值
			}
			means.add(t);
		}
	}

	// 根据质心重新计算簇
	private void updateCluster() {
		int index = 0;
		for (int i = 0; i < K; ++i) // 清空簇
		{
			cluster.get(i).clear();
		}
		for (int i = 0; i < dataNum; ++i) {
			index = clusterOfTuple(tuples.get(i));
			cluster.get(index).add(tuples.get(i));
		}
	}

	// 获取SSE值
	private double getVar() {
		double var = 0;
		for (int i = 0; i < K; ++i) {
			for (int j = 0; j < cluster.get(i).size(); ++j) {
				double d = getDis(cluster.get(i).get(j), means.get(i));
				var += d * d;
			}
		}
		return var;
	}

	// 进行聚类主的函数
	private void cluster() {
		int max = 1500, itNum = 0; 					// 迭代次数
		double oldVar = -1, newVar = -1;

		for (int i = 0; i < K; ++i) {				// 第一步：随机选取K个质心
			int random = (int) (Math.random() * dataNum);
			means.add(tuples.get(random));
		}
		System.out.println("随机初始化质心为：");
		printTuples(means);
		updateCluster();							// 根据到质心的距离初始化簇
		System.out.println("根据质心初始化簇");
		printCluster(cluster);
		newVar = getVar();

		while (Math.abs(newVar - oldVar) > 1 && itNum < max) {
			System.out.println("------------------------第" + itNum
					+ "次迭代开始------------------------------");
			updateMeans();
			System.out.println("根据质心重新计算簇");
			updateCluster();
			printCluster(cluster);
			oldVar = newVar;
			newVar = getVar();
			System.out.println("--------------------------第" + itNum
					+ "次迭代完成，oldVar=" + oldVar + ",newVar=" + newVar
					+ "-------------------------------");
			++itNum;
		}

	}

	private void printT(double[] t) {
		System.out.print((int) t[0] + ".  (");
		for (int i = 1; i < dimNum + 1; ++i) {
			System.out.print(t[i] + ",");
		}
		System.out.println(")");
	}

	private void printTuples(ArrayList<double[]> tuples) {
		for (int i = 0; i < tuples.size(); ++i) {
			printT(tuples.get(i));
		}
	}

	private void printCluster(ArrayList<ArrayList<double[]>> cluster) {
		for (int i = 0; i < K; ++i) {
			System.out.println("第" + i + "个簇,size=" + cluster.get(i).size());
			System.out.print("质心：");
			printT(means.get(i));
			System.out.println("簇中的点：");
			printTuples(cluster.get(i));
			System.out.println();
		}
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		if(args.length!=4)
		{
			System.out.println("please use 3 arguments like this: K dataNum dimensionNum InputFilePath");
			System.out.println("10  ");
			return;
		}
		int K = Integer.valueOf(args[0]);
		int dataNum = Integer.valueOf(args[1]);
		int dimNum = Integer.valueOf(args[2]);
		ArrayList<double[]> tuples = new ArrayList<double[]>();
		double[] t = null;

		File f = new File(args[3]);						// 从磁盘读入文件初始化tuples
		InputStreamReader in = new InputStreamReader(new FileInputStream(f));
		BufferedReader buffer = new BufferedReader(in);
		String lineText = null;
		int i = 0;
		while ((lineText = buffer.readLine()) != null) {
			String vals[] = lineText.split(",");
			t = new double[dimNum + 1];
			t[0] = i; 									// 第一个位置存放记录编号，第2到dimNum+1个位置存放实际元素
			for (int j = 0; j < vals.length - 1; j++) {
				t[j + 1] = Double.valueOf(vals[j]);
			}
			tuples.add(t);
			i++;
		}
		buffer.close();
		// printTuples(tuples);							//打印从文件中读入的tuples
		kmeans exmple = new kmeans(K, dataNum, dimNum, tuples);
		exmple.cluster();
	}

}